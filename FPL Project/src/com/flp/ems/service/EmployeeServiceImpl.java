package com.flp.ems.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.flp.ems.dao.EmployeeDaoImp;
import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

public class EmployeeServiceImpl implements IEmployeeService {

	EmployeeDaoImp employeeDAO = new EmployeeDaoImp();
	
	@Override
	public void addEmployee(HashMap<String, Object> employee) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
		Employee emp = new Employee((String) employee.get("name"), (String) employee.get("address"),
				Integer.parseInt((String) employee.get("phoneNumber")), dateFormat.parse((String) employee.get("dob")),dateFormat.parse((String)employee.get("joiningDate")),
				this.getDepartment(Integer.parseInt((String) employee.get("deptId"))), this.getRole(Integer.parseInt((String) employee.get("roleId"))),
				this.getProject(Integer.parseInt((String) employee.get("projectId"))));
		
		employeeDAO.addEmployee(emp);

	}

	private Department getDepartment(Integer integer) {
		return new Department(505, "Service Layer", "BAPI");
	}
	
	private Role getRole(Integer integer) {
		return new Role(101, "Develop", "Developer");
	}

	private Project getProject(Integer integer) {
		return new Project(302, "Management System", "EMS", getDepartment(505));
	}

	@Override
	public void removeEmployee(Integer employeeId) {
		Employee emp = employeeDAO.searchEmployeebyId(employeeId);
		employeeDAO.removeEmployee(emp);

	}

	@Override
	public void modifyEmployee(HashMap<String,Object> employee) {
		int employeeId = Integer.parseInt((String) employee.get("employeeId"));
		
		Employee emp = employeeDAO.searchEmployeebyId(employeeId);
		
		emp.setAddress((String)employee.get("address"));
		emp.setPhoneNumber(Integer.parseInt((String) employee.get("phoneNumber")));
		emp.setDept(this.getDepartment(Integer.parseInt((String) employee.get("deptId"))));
		emp.setRole(this.getRole(Integer.parseInt((String) employee.get("roleId"))));
		emp.setProject(this.getProject(Integer.parseInt((String) employee.get("projectId"))));
		
		employeeDAO.modifyEmployee(emp);

	}

	@Override
	public Employee searchEmployee(Integer employeeId) {
		Employee emp = employeeDAO.searchEmployeebyId(employeeId);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployee();
	}

}
