package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.flp.ems.domain.Department;

public class DepartmentDao {

	private Connection dbConnection;
	private Properties dbProperties;
	
	
	public DepartmentDao() throws IOException, SQLException, ClassNotFoundException {
		dbProperties = new Properties();
		FileInputStream fileInputStream = new FileInputStream("dbDetails.properties");
		dbProperties.load(fileInputStream);
		
		String driver = dbProperties.getProperty("jdbc.driver");
		Class.forName(driver);
		
		dbConnection = DriverManager.getConnection(dbProperties.getProperty("jdbc.url"),"root","root123");
		
	}


	public Department getDepartmentById(int departmentId) throws SQLException {
		Department department = null;

		try (PreparedStatement selectStatement = dbConnection
				.prepareStatement(dbProperties.getProperty("jdbc.selectbyid.department"))) {
			selectStatement.setInt(1, departmentId);
			ResultSet resultSet = selectStatement.executeQuery();
			if (resultSet.next()) {
				department = new Department(resultSet.getInt("Department_Id"), resultSet.getString("Name"),
						resultSet.getString("Description"));
			}
		}
		return department;
	}

	
}
