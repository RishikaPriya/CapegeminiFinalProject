package com.flp.ems.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {

	public void addEmployee(HashMap<String, String> employee) throws ParseException, SQLException;

	public void removeEmployee(Integer employeeId) throws SQLException;

	public void modifyEmployee(HashMap<String, String> employee) throws SQLException;

	public Employee searchEmployee(Integer employeeId) throws SQLException;

	public List<Employee> getAllEmployees() throws SQLException;

}
