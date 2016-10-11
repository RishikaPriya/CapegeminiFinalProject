package com.flp.ems.util;

import java.io.IOException;
import java.sql.SQLException;

import com.flp.ems.dao.DepartmentDao;
import com.flp.ems.dao.EmployeeDaoImp;
import com.flp.ems.dao.IEmployeeDao;
import com.flp.ems.dao.ProjectDao;
import com.flp.ems.dao.RoleDao;

public class Dao {
	private static IEmployeeDao employeeDao = null;
	private static DepartmentDao departmentDao = null;
	private static RoleDao roleDao = null;
	private static ProjectDao projectDao = null;

	static {
		try {
			employeeDao = new EmployeeDaoImp();
			departmentDao = new DepartmentDao();
			roleDao = new RoleDao();
			projectDao = new ProjectDao();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	public static IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public static DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public static RoleDao getRoleDao() {
		return roleDao;
	}

	public static ProjectDao getProjectDao() {
		return projectDao;
	}
}
