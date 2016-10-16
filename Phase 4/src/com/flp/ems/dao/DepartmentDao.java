package com.flp.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.flp.ems.domain.Department;

@Repository
public class DepartmentDao implements IDepartmentDao {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	public DepartmentDao() {
	//	jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartmentById(int departmentId) {
		String sql = "select * from Department where Department_Id=" + departmentId;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Department>() {

			@Override
			public Department extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				if (resultSet.next()) {
					Department department = new Department(resultSet.getInt("Department_Id"),
							resultSet.getString("Description"), resultSet.getString("Name"));
					return department;
				}
				return null;
			}

		});
	}

}
