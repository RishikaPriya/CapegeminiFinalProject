package com.flp.ems.dao;

import java.util.List;

import com.flp.ems.domain.Employee;

public interface IEmployeeDao {

	public void addEmployee(Employee employee);

	public void modifyEmployee(Employee employee);

	public void removeEmployee(Employee employee);

	public Employee searchEmployeebyId(int employeeId);

	public List<Employee> getAllEmployee();
}
