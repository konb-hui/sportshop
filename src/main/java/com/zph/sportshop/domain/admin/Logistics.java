package com.zph.sportshop.domain.admin;

import java.io.Serializable;
import java.util.Set;

import com.zph.sportshop.domain.basedata.Myorder;

public class Logistics implements Serializable{
	private Long lid;
	private String lname;
	private Set<Myorder> myorders;
	public Long getLid() {
		return lid;
	}
	public void setLid(Long lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Set<Myorder> getMyorders() {
		return myorders;
	}
	public void setMyorders(Set<Myorder> myorders) {
		this.myorders = myorders;
	}
}
