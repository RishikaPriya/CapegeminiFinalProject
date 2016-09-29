package com.flp.ems.service;

import java.util.HashMap;
import java.util.List;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {

	public void addEmployee(HashMap<String, Object> employee);

	public void removeEmployee(Integer employeeId);

	public void modifyEmployee(HashMap employee);

	public Employee searchEmployee(Integer employeeId);

	public List<Employee> getAllEmployees();
}
