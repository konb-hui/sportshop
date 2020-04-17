package com.zph.sportshop.domain.system;

import java.io.Serializable;
import java.sql.Date;

import com.zph.sportshop.domain.admin.Admin;

public class Info implements Serializable{
	private Long infoId;
	private String content;
	private Date time;
	private Admin admin;
	public Long getInfoId() {
		return infoId;
	}
	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
