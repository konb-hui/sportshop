package com.zph.sportshop.domain.privilege;

import java.io.Serializable;
import java.util.Set;

public class Privilege implements Serializable{
	private Long pid;
	private String functionName;
	private Set<Role> roles;
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
}
