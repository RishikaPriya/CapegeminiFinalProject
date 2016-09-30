package com.flp.ems.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;

public class UserInteraction {

	Scanner input = new Scanner(System.in);
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	public void addEmployee() throws ParseException{
		//inputEmployeeDetail();
		HashMap<String, Object> employeeList = new HashMap<String,Object>();
		
		System.out.println("Enter Employee Details\n");
		
		System.out.println("Enter employee's name: ");
		String name = input.nextLine();
		employeeList.put("name", name);
		
		System.out.println("Enter employee's contact number: ");
		String phoneNumber = input.nextLine();
		employeeList.put("phoneNumber",phoneNumber);
		
		System.out.println("Enter employee's address: ");
		String address = input.nextLine();
		employeeList.put("address",address);
		
		System.out.println("Enter employee's date of birth: ");
		String dob = input.nextLine();
		employeeList.put("dob", dob);
		
		System.out.println("Enter employee's date of joining: ");
		String joiningDate = input.nextLine();
		employeeList.put("joiningDate", joiningDate);
		
		System.out.println("Enter employee's department id: ");
		String deptId = input.nextLine();
		employeeList.put("deptId", deptId);
		
		System.out.println("Enter employee's role id: ");
		String roleId = input.nextLine();
		employeeList.put("roleId", roleId);
		
		System.out.println("Enter employee's project id: ");
		String projectId = input.nextLine();
		employeeList.put("projectId", projectId);
		
		employeeService.addEmployee(employeeList);
	}

	public void modifyEmployee() {
		HashMap<String, Object> employeeList = new HashMap<String,Object>();
		
		System.out.println("Enter employee id: ");
		String employeeId = input.nextLine();
		employeeList.put("employeeId", employeeId);
		
		System.out.println("Enter Employee Details for Modification\n");
		
		System.out.println("Enter employee's contact number: ");
		String phoneNumber = input.nextLine();
		employeeList.put("phoneNumber",phoneNumber);
		
		System.out.println("Enter employee's address: ");
		String address = input.nextLine();
		employeeList.put("address",address);
		
		System.out.println("Enter employee's department id: ");
		String deptId = input.nextLine();
		employeeList.put("deptId", deptId);
		
		System.out.println("Enter employee's role id: ");
		String roleId = input.nextLine();
		employeeList.put("roleId", roleId);
		
		System.out.println("Enter employee's project id: ");
		String projectId = input.nextLine();
		employeeList.put("projectId", projectId);
		
		employeeService.modifyEmployee(employeeList);
	}

	public void removeEmployee() {
		System.out.println("Enter the employee id: ");
		String employeeId = input.nextLine();
		employeeService.removeEmployee(Integer.parseInt(employeeId));

	}

	public void searchEmployee() {
		System.out.println("Enter the employee id: ");
		String employeeId = input.nextLine();
		int id = Integer.parseInt(employeeId);
		System.out.println(employeeService.searchEmployee(id).toString());
	}

	public void getAllEmployee() {
		List<Employee> empList = employeeService.getAllEmployees();
		for(Employee emp : empList){
			System.out.println(emp.toString());
		}
		
	}

/*	private static void inputEmployeeDetail() {
		Map<String, Object> employeeList = new HashMap<String,Object>();
		
		System.out.println("Enter Employee Details\n");
		
		System.out.println("Enter employee's name: ");
		String name = input.nextLine();
		employeeList.put("name", name);
		
		System.out.println("Enter employee's address: ");
		String address = input.nextLine();
		employeeList.put("address",address);
		
		System.out.println("Enter employee's contact number: ");
		Long phoneNumber = input.nextLong();
		employeeList.put("phoneNumber",phoneNumber);
		
		
		System.out.println("Enter employee's date of birth: ");
		String dob = input.nextLine();
		employeeList.put("dob", dob);
		
		System.out.println("Enter employee's date of joining: ");
		String joiningDate = input.nextLine();
		employeeList.put("joining", joiningDate);
		
		System.out.println("Enter employee's department id: ");
		int deptId = input.nextInt();
		employeeList.put("deptId", deptId);
		
		System.out.println("Enter employee's role id: ");
		int roleId = input.nextInt();
		employeeList.put("roleId", roleId);
		
		System.out.println("Enter employee's project id: ");
		int projectId = input.nextInt();
		employeeList.put("projectId", projectId);
	}
*/
}
