package com.flp.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.flp.ems.domain.Role;

@Repository
public class RoleDao implements IRoleDao {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);

	public RoleDao() {
		//jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Role getRoleById(int roleId) {
		String sql = "select * from Role where Role_Id=" + roleId;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Role>() {

			@Override
			public Role extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				if (resultSet.next()) {
					Role role = new Role(resultSet.getInt("Role_Id"), resultSet.getString("Description"),
							resultSet.getString("Name"));
					return role;
				}
				return null;
			}

		});
	}

}
