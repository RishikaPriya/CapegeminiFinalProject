package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.flp.ems.domain.Project;
import com.flp.ems.util.DataSourceFactory;

public class ProjectDao {

	private Connection dbConnection;
	private Properties dbProperties;
	private DepartmentDao departmentDao;

	public ProjectDao() throws SQLException, IOException{
		dbProperties = new Properties();

		/*ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("/WEB-INF/lib/dbDetails.properties");
		
	*/FileInputStream fileInputStream = new FileInputStream("dbDetails.properties");
		dbProperties.load(fileInputStream);
		dbConnection = DataSourceFactory.getDataSource(dbProperties.getProperty("jdbc.database.resource"))
				.getConnection();

		departmentDao = new DepartmentDao();
	}

	public Project getProjectById(int projectId) throws SQLException {
		Project project = null;

		try (PreparedStatement selectStatement = dbConnection
				.prepareStatement(dbProperties.getProperty("jdbc.selectbyid.project"))) {
			selectStatement.setInt(1, projectId);
			ResultSet resultSet = selectStatement.executeQuery();
			if (resultSet.next()) {
				project = new Project(resultSet.getInt("Project_Id"), resultSet.getString("Name"),
						resultSet.getString("Description"),
						departmentDao.getDepartmentById(resultSet.getInt("Department_Id")));
			}
		}
		return project;
	}
}
