package com.flp.ems.domain;

import java.util.Date;

public class Employee {

	private static int idGenerator = 1001;
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

	public Employee(String name, String address, long phoneNumber, Date dob, Date joiningDate, Department dept,
			Role role, Project project) {
		this.employeeId = Employee.idGenerator++;
		this.kinId = generateKinId();
		this.name = name;
		this.address = address;
		this.emailId = generateEmailId(name, employeeId);
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.joiningDate = joiningDate;
		this.dept = dept;
		this.role = role;
		this.project = project;
	}

	public Employee(int employeeId, String name, String kinId, String emailId, long phoneNumber, Date dob,
			Date joiningDate, String address, Department dept, Project project, Role role) {
		this.employeeId = employeeId;
		this.name = name;
		this.kinId = kinId;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.joiningDate = joiningDate;
		this.address = address;
		this.dept = dept;
		this.project = project;
		this.role = role;
	}

	private String generateEmailId(String name, int employeeId) {
		String[] nameArr = name.split(" ");
		String emailId = nameArr[0].toLowerCase() + "." + nameArr[1].toLowerCase() + "@abc.com";
		return emailId;
	}

	private String generateKinId() {
		int kinIdIncrementer = 600;
		String kinId = (kinIdIncrementer++) + "_TS";
		return kinId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setProject(Project project) {
		this.project = project;
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
		return String.format("Employee Id: " + employeeId + "\nName: " + name + "\nKin-id: " + kinId
				+ "\nContact Number: " + phoneNumber + "\nAddress: " + address + "\nEmail-id: " + emailId + "\n\n");
	}

	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		return (this.getEmployeeId() == emp.getEmployeeId());
	}

	@Override
	public int hashCode() {
		return this.getEmployeeId();
	}
}
