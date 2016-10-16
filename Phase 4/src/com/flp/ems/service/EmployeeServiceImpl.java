package com.flp.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flp.ems.dao.IEmployeeDao;
import com.flp.ems.domain.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDAO;
		
	@Override
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}
	
	@Override
	public void removeEmployee(Integer employeeId) {
		Employee employee = employeeDAO.searchEmployeebyId(employeeId);
		employeeDAO.removeEmployee(employee);
	}
	
	@Override
	public void modifyEmployee(Employee employee) {
		employeeDAO.modifyEmployee(employee);
	}
	
	@Override
	public Employee searchEmployee(Integer employeeId) {
		return employeeDAO.searchEmployeebyId(employeeId);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployee();
	}
	
	

	
}
