package com.flp.ems.view;

import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;

public class UserInteraction {

	static Scanner input = new Scanner(System.in);
	static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	public static void addEmployee() {
		inputEmployeeDetail();
	}

	public static void modifyEmployee() {

	}

	public static void removeEmployee() {
		System.out.println("Enter the employee id: ");
		int employeeId = input.nextInt();
		employeeService.removeEmployee(employeeId);

	}

	public static void searchEmployee() {
		System.out.println("Enter the employee id: ");
		int employeeId = input.nextInt();
		employeeService.searchEmployee(employeeId);
	}

	public static void getAllEmployee() {
		// List<Object> employeeList = employeeService.getAllEmployees();
	}

	private static void inputEmployeeDetail() {
		System.out.println("Enter Employee Details\n");
		System.out.println("Enter employee's name: ");
		String name = input.nextLine();
		System.out.println("Enter employee's address: ");
		String address = input.nextLine();
		System.out.println("Enter employee's contact number: ");
		Long phoneNumber = input.nextLong();
		System.out.println("Enter employee's date of birth: ");
		String dob = input.nextLine();
		System.out.println("Enter employee's date of joining: ");
		String joiningDate = input.nextLine();
		System.out.println("Enter employee's department id: ");
		int deptId = input.nextInt();
		System.out.println("Enter employee's role id: ");
		int roleId = input.nextInt();
		System.out.println("Enter employee's project id: ");
		int projectId = input.nextInt();
	}
}
