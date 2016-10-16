package com.flp.ems.domain;

public class Project {

	private int projectId;
	private String projectDescription;
	private String projectName;
	private Department dept;

	public Project(int projectId, String projectDescription, String projectName, Department dept) {
		this.projectId = projectId;
		this.projectDescription = projectDescription;
		this.projectName = projectName;
		this.dept = dept;
	}

	public int getProjectId() {
		return projectId;
	}

}
