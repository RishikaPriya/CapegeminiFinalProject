package com.flp.ems.service;


import java.util.List;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {

	public void addEmployee(Employee employee);

	public void removeEmployee(Integer employeeId);

	public void modifyEmployee(Employee employee);

	public Employee searchEmployee(Integer employeeId);

	public List<Employee> getAllEmployees();

}
