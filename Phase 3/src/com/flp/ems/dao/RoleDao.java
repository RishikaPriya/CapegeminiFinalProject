package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.flp.ems.domain.Role;
import com.flp.ems.util.DataSourceFactory;

public class RoleDao {

	private Connection dbConnection;
	private Properties dbProperties;

	public RoleDao() throws IOException, SQLException, ClassNotFoundException {
		dbProperties = new Properties();

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("dbDetails.properties");

		// FileInputStream fileInputStream = new
		// FileInputStream("dbDetails.properties");
		dbProperties.load(input);

		String driver = dbProperties.getProperty("jdbc.driver");
		Class.forName(driver);
		
		dbConnection = DriverManager.getConnection(dbProperties.getProperty("jdbc.url"),"root","root123");
		
	}

	public Role getRoleById(int roleId) throws SQLException {
		Role role = null;

		try (PreparedStatement selectStatement = dbConnection
				.prepareStatement(dbProperties.getProperty("jdbc.selectbyid.role"))) {
			selectStatement.setInt(1, roleId);
			ResultSet resultSet = selectStatement.executeQuery();
			if (resultSet.next()) {
				role = new Role(resultSet.getInt("Role_Id"), resultSet.getString("Name"),
						resultSet.getString("Description"));
			}
		}
		return role;
	}

}
