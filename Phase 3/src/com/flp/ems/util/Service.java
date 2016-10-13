package com.flp.ems.util;

import java.io.IOException;
import java.sql.SQLException;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.service.IEmployeeService;

public class Service {
	private static IEmployeeService employeeService = null;

	static {
		try {
			employeeService = new EmployeeServiceImpl();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	/*private Service() {
	}
	*/
	public static IEmployeeService getEmployeeService() {
		return employeeService;
	}
}
