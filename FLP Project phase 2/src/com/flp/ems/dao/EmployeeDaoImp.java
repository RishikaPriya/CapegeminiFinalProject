package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImp implements IEmployeeDao {

	private Connection dbConnection;
	private Properties dbProperties = new Properties();
	private ProjectDao projectDao;
	private DepartmentDao departmentDao;
	private RoleDao roleDao;

	public EmployeeDaoImp() throws IOException, SQLException, ClassNotFoundException {

		projectDao = new ProjectDao();
		departmentDao = new DepartmentDao();
		roleDao = new RoleDao();

		FileInputStream fileInputStream = new FileInputStream("dbDetails.properties");
		dbProperties.load(fileInputStream);

		String driver = dbProperties.getProperty("jdbc.driver");
		Class.forName(driver);

		dbConnection = DriverManager.getConnection(dbProperties.getProperty("jdbc.url"), "root", "root123");

	}

	@Override
	public void addEmployee(Employee employee) throws SQLException {

		try (PreparedStatement insertStatement = dbConnection
				.prepareStatement(dbProperties.getProperty("jdbc.insert.employee"))) {

			insertStatement.setInt(1, employee.getEmployeeId());
			insertStatement.setString(2, employee.getName());
			insertStatement.setString(3, employee.getKinId());
			insertStatement.setString(4, employee.getEmailId());
			insertStatement.setLong(5, employee.getPhoneNumber());
			insertStatement.setDate(6, dateConversion(employee.getDob()));
			insertStatement.setDate(7, dateConversion(employee.getJoiningDate()));
			insertStatement.setString(8, employee.getAddress());
			insertStatement.setInt(9, employee.getDept().getDeptId());
			insertStatement.setInt(10, employee.getProject().getProjectId());
			insertStatement.setInt(11, employee.getRole().getRoleId());

			int rows = insertStatement.executeUpdate();
			System.out.println(rows + " row(s) updated.");
		}
	}

	@Override
	public void modifyEmployee(Employee employee) throws SQLException {
		try (PreparedStatement modifyStatement = dbConnection
				.prepareStatement(dbProperties.getProperty("jdbc.modify.employee"))) {
			modifyStatement.setLong(1, employee.getPhoneNumber());
			modifyStatement.setInt(2, employee.getDept().getDeptId());
			modifyStatement.setInt(3, employee.getProject().getProjectId());
			modifyStatement.setInt(4, employee.getRole().getRoleId());
			modifyStatement.setString(5, employee.getAddress());
			modifyStatement.setInt(6, employee.getEmployeeId());

			int rows = modifyStatement.executeUpdate();
			System.out.println(rows + "row(s) updated");
		}
	}

	@Override
	public void removeEmployee(Employee employee) throws SQLException {
		try (PreparedStatement removeStatement = dbConnection
				.prepareStatement(dbProperties.getProperty("jdbc.remove.employee"))) {
			removeStatement.setInt(1, employee.getEmployeeId());

			int rows = removeStatement.executeUpdate();
			System.out.println(rows + " row(s) updated.");
		}
	}

	@Override
	public Employee searchEmployeebyId(int employeeId) throws SQLException {

		Employee emp = null;
		try (PreparedStatement selectStatement = dbConnection
				.prepareStatement(dbProperties.getProperty("jdbc.selectbyid.employee"))) {
			selectStatement.setInt(1, employeeId);
			ResultSet resultSet = selectStatement.executeQuery();

			while (resultSet.next()) {
				emp = new Employee(resultSet.getInt("Employee_Id"), resultSet.getString("Name"),
						resultSet.getString("Kin_Id"), resultSet.getString("EmailId"), resultSet.getLong("PhoneNo"),
						resultSet.getDate("Date_Of_Birth"), resultSet.getDate("Date_Of_Joining"),
						resultSet.getString("Address"),
						departmentDao.getDepartmentById(resultSet.getInt("Department_Id")),
						projectDao.getProjectById(resultSet.getInt("Project_Id")),
						roleDao.getRoleById(resultSet.getInt("Role_Id")));
			}
			return emp;
		}

	}

	@Override
	public List<Employee> getAllEmployee() throws SQLException {

		ArrayList<Employee> employees = new ArrayList<>();

		try (PreparedStatement selectStatement = dbConnection
				.prepareStatement(dbProperties.getProperty("jdbc.selectall.employee"))) {

			ResultSet resultSet = selectStatement.executeQuery();

			while (resultSet.next()) {
				employees.add(new Employee(resultSet.getInt("Employee_Id"), resultSet.getString("Name"),
						resultSet.getString("Kin_Id"), resultSet.getString("EmailId"), resultSet.getLong("phoneNo"),
						resultSet.getDate("Date_Of_Birth"), resultSet.getDate("Date_Of_Joining"),
						resultSet.getString("Address"),
						departmentDao.getDepartmentById(resultSet.getInt("Department_Id")),
						projectDao.getProjectById(resultSet.getInt("Project_Id")),
						roleDao.getRoleById(resultSet.getInt("Role_Id"))));
			}

			return employees;
		}
	}

	private java.sql.Date dateConversion(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}
}
