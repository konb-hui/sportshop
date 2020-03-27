package com.zph.sportshop.domain.basedata;

public class User {
	private Long uid;
	private String username;
	private String password;
	private String account;
	private String sex;
	private String email;
	private String phone;
	private Integer isvip;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getIsvip() {
		return isvip;
	}
	public void setIsvip(Integer isvip) {
		this.isvip = isvip;
	}
	
}
