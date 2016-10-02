package com.flp.ems.dao;

import java.sql.SQLException;
import java.util.List;

import com.flp.ems.domain.Employee;

public interface IEmployeeDao {

	public void addEmployee(Employee employee) throws SQLException;

	public void modifyEmployee(Employee employee) throws SQLException;

	public void removeEmployee(Employee employee) throws SQLException;

	public Employee searchEmployeebyId(int employeeId) throws SQLException;

	public List<Employee> getAllEmployee() throws SQLException;
}
