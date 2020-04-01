package com.zph.sportshop.domain.privilege;

import java.io.Serializable;
import java.util.Set;

import com.zph.sportshop.domain.admin.Admin;

public class Role implements Serializable{
	private Long rid;
	private String rname;
	private Set<Admin> admins;
	private Set<Privilege> privileges;
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	public Set<Admin> getAdmins() {
		return admins;
	}
	public void setAdmins(Set<Admin> admins) {
		this.admins = admins;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
}
