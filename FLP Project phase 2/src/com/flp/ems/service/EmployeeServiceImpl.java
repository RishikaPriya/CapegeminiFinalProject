package com.flp.ems.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.flp.ems.dao.DepartmentDao;
import com.flp.ems.dao.EmployeeDaoImp;
import com.flp.ems.dao.ProjectDao;
import com.flp.ems.dao.RoleDao;
import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

public class EmployeeServiceImpl implements IEmployeeService {

	private EmployeeDaoImp employeeDAO;
	private ProjectDao projectDao;
	private DepartmentDao departmentDao;
	private RoleDao roleDao;
	
	public EmployeeServiceImpl() throws ClassNotFoundException, IOException, SQLException {
		this.employeeDAO = new EmployeeDaoImp();
		this.departmentDao = new DepartmentDao();
		this.projectDao = new ProjectDao();
		this.roleDao = new RoleDao();
	}
	
	@Override
	public void addEmployee(HashMap<String, Object> employee) throws ParseException, SQLException{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
		Employee emp = new Employee((String) employee.get("name"), (String) employee.get("address"),
				Long.parseLong((String) employee.get("phoneNumber")), dateFormat.parse((String) employee.get("dob")),dateFormat.parse((String)employee.get("joiningDate")),
				this.departmentDao.getDepartmentById(Integer.parseInt((String) employee.get("deptId"))), this.roleDao.getRoleById(Integer.parseInt((String) employee.get("roleId"))),
				this.projectDao.getProjectById(Integer.parseInt((String) employee.get("projectId"))));
		
		employeeDAO.addEmployee(emp);

	}

	/*private Department getDepartment(Integer integer) {
		return new Department(505, "Service Layer", "BAPI");
	}
	
	private Role getRole(Integer integer) {
		return new Role(101, "Develop", "Developer");
	}

	private Project getProject(Integer integer) {
		return new Project(302, "Management System", "EMS", getDepartment(505));
	}*/

	@Override
	public void removeEmployee(Integer employeeId) throws SQLException {
		Employee emp = employeeDAO.searchEmployeebyId(employeeId);
		employeeDAO.removeEmployee(emp);

	}

	@Override
	public void modifyEmployee(HashMap<String,Object> employee) throws SQLException {
		int employeeId = Integer.parseInt((String) employee.get("employeeId"));
		
		Employee emp = employeeDAO.searchEmployeebyId(employeeId);
		
		emp.setAddress((String)employee.get("address"));
		emp.setPhoneNumber(Integer.parseInt((String) employee.get("phoneNumber")));
		emp.setDept(this.departmentDao.getDepartmentById(Integer.parseInt((String) employee.get("deptId"))));
		emp.setRole(this.roleDao.getRoleById(Integer.parseInt((String) employee.get("roleId"))));
		emp.setProject(this.projectDao.getProjectById(Integer.parseInt((String) employee.get("projectId"))));
		
		employeeDAO.modifyEmployee(emp);

	}

	@Override
	public Employee searchEmployee(Integer employeeId) throws SQLException {
		Employee emp = employeeDAO.searchEmployeebyId(employeeId);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		return employeeDAO.getAllEmployee();
	}

}
