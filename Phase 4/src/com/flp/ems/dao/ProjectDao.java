package com.flp.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.flp.ems.domain.Project;

@Repository
public class ProjectDao implements IProjectDao {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private IDepartmentDao departmentDao;

	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);;
	
	public ProjectDao() {
		//jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProjectById(int projectId) {
		String sql = "select * from Project where Project_Id=" + projectId;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Project>() {

			@Override
			public Project extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				if (resultSet.next()) {
					Project project = new Project(resultSet.getInt("Project_Id"), resultSet.getString("Description"), resultSet.getString("Name"),
							departmentDao.getDepartmentById(resultSet.getInt("Department_Id")));
					return project;
				}
				return null;
			}

		});
	}
}
