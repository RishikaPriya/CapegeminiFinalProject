package com.flp.ems.domain;

public class Role {
	private int roleId;
	private String roleDescription;
	private String roleName;

	public Role(int roleId, String roleDescription, String roleName) {
		this.roleId = roleId;
		this.roleDescription = roleDescription;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}
}
