package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.List;
import com.flp.ems.domain.Employee;

public class EmployeeDaoImp implements IEmployeeDao{

	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	@Override
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

	@Override
	public void modifyEmployee(Employee employee) {
		int index = employeeList.indexOf(employee);
		employeeList.set(index, employee);
	}

	@Override
	public void removeEmployee(Employee employee) {
		employeeList.remove(employee);
	}

	@Override
	public Employee searchEmployeebyId(int employeeId) {
		
		for(Employee emp : employeeList){
			if(emp.getEmployeeId() == employeeId){
				return emp;
			}
		}
		return null;
		
	}

	@Override
	public List<Employee> getAllEmployee() {

		return employeeList;
	}


}
