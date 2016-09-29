package com.flp.ems.domain;

public class Department {

	private int deptId;
	private String deptDescription;
	private String deptName;

	public Department(int deptId, String deptDescription, String deptName) {
		this.deptId = deptId;
		this.deptDescription = deptDescription;
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

}
