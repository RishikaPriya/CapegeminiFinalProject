package com.flp.ems.domain;

import java.util.Date;

public class Employee {

	private static int idGenerator = 1000;
	private int employeeId;
	private String kinId;
	private String name;
	private String address;
	private String emailId;
	private long phoneNumber;
	private Date dob;
	private Date joiningDate;
	private Department dept;
	private Role role;
	private Project project;

	public Employee(String name, String address, long phoneNumber,
			Date dob, Date joiningDate, Department dept, Role role, Project project) {
		this.employeeId = Employee.idGenerator++;
		this.kinId = generateKinId();
		this.name = name;
		this.address = address;
		this.emailId = generateEmailId(name,employeeId);
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.joiningDate = joiningDate;
		this.dept = dept;
		this.role = role;
		this.project = project;
	}

	private String generateEmailId(String name, int employeeId) {
		String[] nameArr = name.split(" ");
		String emailId = nameArr[0].toLowerCase() + "." + nameArr[1].toLowerCase() + "@abc.com";
		return emailId;
	}
	
	private String generateKinId() {
		int kinIdIncrementer=600;
		String kinId = (kinIdIncrementer++) + "_TS";
		return kinId;
	}
	public int getEmployeeId() {
		return employeeId;
	}

	public static int getIdGenerator() {
		return idGenerator;
	}

	public String getKinId() {
		return kinId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmailId() {
		return emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public Date getDob() {
		return dob;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public Department getDept() {
		return dept;
	}

	public Role getRole() {
		return role;
	}

	public Project getProject() {
		return project;
	}	
	
	@Override
	public String toString() {
		String.format("Employee Id: " + employeeId + "\nName: " + name);
		return super.toString();
	}
	
}
