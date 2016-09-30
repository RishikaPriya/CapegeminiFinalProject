package com.flp.ems.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {

	public void addEmployee(HashMap<String, Object> employee) throws ParseException;

	public void removeEmployee(Integer employeeId);

	public void modifyEmployee(HashMap<String, Object> employee);

	public Employee searchEmployee(Integer employeeId);

	public List<Employee> getAllEmployees();
}
