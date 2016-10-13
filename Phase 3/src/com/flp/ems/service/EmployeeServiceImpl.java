package com.flp.ems.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import com.flp.ems.dao.DepartmentDao;
import com.flp.ems.dao.IEmployeeDao;
import com.flp.ems.dao.ProjectDao;
import com.flp.ems.dao.RoleDao;
import com.flp.ems.domain.Employee;
import com.flp.ems.util.Dao;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDao employeeDAO;
	private ProjectDao projectDao;
	private DepartmentDao departmentDao;
	private RoleDao roleDao;

	public EmployeeServiceImpl() throws IOException, SQLException {
		this.employeeDAO = Dao.getEmployeeDao();
		this.departmentDao = Dao.getDepartmentDao();
		this.projectDao = Dao.getProjectDao();
		this.roleDao = Dao.getRoleDao();
	}

	@Override
	public void addEmployee(HashMap<String, String> employee) throws ParseException, SQLException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Employee emp = new Employee(employee.get("name"), employee.get("address"),
				Long.parseLong(employee.get("phoneNumber")), dateFormat.parse(employee.get("dob")),
				dateFormat.parse(employee.get("joiningDate")),
				this.departmentDao.getDepartmentById(Integer.parseInt(employee.get("deptId"))),
				this.roleDao.getRoleById(Integer.parseInt(employee.get("roleId"))),
				this.projectDao.getProjectById(Integer.parseInt(employee.get("projectId"))));

		employeeDAO.addEmployee(emp);

	}

	/*
	 * private Department getDepartment(Integer integer) { return new
	 * Department(505, "Service Layer", "BAPI"); }
	 * 
	 * private Role getRole(Integer integer) { return new Role(101, "Develop",
	 * "Developer"); }
	 * 
	 * private Project getProject(Integer integer) { return new Project(302,
	 * "Management System", "EMS", getDepartment(505)); }
	 */

	@Override
	public void removeEmployee(Integer employeeId) throws SQLException {
		Employee emp = employeeDAO.searchEmployeebyId(employeeId);
		employeeDAO.removeEmployee(emp);

	}

	@Override
	public void modifyEmployee(HashMap<String, String> employee) throws SQLException {
		int employeeId = Integer.parseInt(employee.get("employeeId"));

		Employee emp = employeeDAO.searchEmployeebyId(employeeId);

		emp.setAddress(employee.get("address"));
		emp.setPhoneNumber(Integer.parseInt(employee.get("phoneNumber")));
		emp.setDept(this.departmentDao.getDepartmentById(Integer.parseInt(employee.get("deptId"))));
		emp.setRole(this.roleDao.getRoleById(Integer.parseInt(employee.get("roleId"))));
		emp.setProject(this.projectDao.getProjectById(Integer.parseInt(employee.get("projectId"))));

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
