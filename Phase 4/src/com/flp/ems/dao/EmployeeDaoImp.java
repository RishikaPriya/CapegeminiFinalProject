package com.flp.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;

@Repository
public class EmployeeDaoImp implements IEmployeeDao {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private IProjectDao projectDao;
	@Autowired
	private IDepartmentDao departmentDao;
	@Autowired
	private IRoleDao roleDao;

	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	public EmployeeDaoImp() {
		/*projectDao = new ProjectDao();
		departmentDao = new DepartmentDao();
		roleDao = new RoleDao();
		jdbcTemplate = new JdbcTemplate(dataSource);
		 */
	}

	private java.sql.Date dateConversion(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}

	@Override
	public void addEmployee(Employee employee) {
		String sql = "insert into Employee values(?,?,?,?,?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql,
				new Object[] { employee.getEmployeeId(), employee.getName(), employee.getKinId(), employee.getEmailId(),
						employee.getPhoneNumber(), dateConversion(employee.getDob()),
						dateConversion(employee.getJoiningDate()), employee.getAddress(),
						employee.getDept().getDeptId(), employee.getProject().getProjectId(),
						employee.getRole().getRoleId() });
	}

	@Override
	public void modifyEmployee(Employee employee) {
		String sql = "update Employee set PhoneNo=?, Department_Id=?, Project_Id=?, Role_Id=?, address=? where Employee_Id=?";

		jdbcTemplate.update(sql,
				new Object[] { employee.getPhoneNumber(), employee.getDept().getDeptId(),
						employee.getProject().getProjectId(), employee.getRole().getRoleId(), employee.getAddress(),
						employee.getEmployeeId() });
	}

	@Override
	public void removeEmployee(Employee employee) {
		String sql = "delete from Employee where Employee_Id=" + employee.getEmployeeId();
		jdbcTemplate.update(sql);
	}

	@Override
	public Employee searchEmployeebyId(int employeeId) {
		String sql = "select * from Employee where Employee_Id=" + employeeId;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				if (resultSet.next()) {
					Employee employee = new Employee(resultSet.getInt("Employee_Id"), resultSet.getString("Name"),
							resultSet.getString("Kin_Id"), resultSet.getString("EmailId"), resultSet.getLong("PhoneNo"),
							resultSet.getDate("Date_Of_Birth"), resultSet.getDate("Date_Of_Joining"),
							resultSet.getString("Address"),
							departmentDao.getDepartmentById(resultSet.getInt("Department_Id")),
							projectDao.getProjectById(resultSet.getInt("Project_Id")),
							roleDao.getRoleById(resultSet.getInt("Role_Id")));
					return employee;
				}
				return null;
			}

		});
	}

	@Override
	public List<Employee> getAllEmployee() {
		String sql = "select * from Employee";
		List<Employee> empList = jdbcTemplate.query(sql, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Employee emp = new Employee(resultSet.getInt("Employee_Id"), resultSet.getString("Name"),
						resultSet.getString("Kin_Id"), resultSet.getString("EmailId"), resultSet.getLong("PhoneNo"),
						resultSet.getDate("Date_Of_Birth"), resultSet.getDate("Date_Of_Joining"),
						resultSet.getString("Address"),
						departmentDao.getDepartmentById(resultSet.getInt("Department_Id")),
						projectDao.getProjectById(resultSet.getInt("Project_Id")),
						roleDao.getRoleById(resultSet.getInt("Role_Id")));

				return emp;
			}

		});

		return empList;
	}
}
