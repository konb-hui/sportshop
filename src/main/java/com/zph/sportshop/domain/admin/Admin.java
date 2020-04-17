package com.zph.sportshop.domain.admin;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import com.zph.sportshop.domain.privilege.Role;
import com.zph.sportshop.domain.system.Info;

public class Admin implements Serializable{
	private Long adminId;
	private String adminName;
	private String password;
	private String trueName;
	private String phone;
	private String email;
	private String sex;
	private Date regTime;
	private Role role;
	private Set<Info> infos;
	public Set<Info> getInfos() {
		return infos;
	}
	public void setInfos(Set<Info> infos) {
		this.infos = infos;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
}
