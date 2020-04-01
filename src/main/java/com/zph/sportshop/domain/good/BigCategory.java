package com.zph.sportshop.domain.good;

import java.io.Serializable;
import java.util.Set;

public class BigCategory implements Serializable{
	private int bcid;
	private String bcname;
	private Set<Category> categories;
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public int getBcid() {
		return bcid;
	}
	public void setBcid(int bcid) {
		this.bcid = bcid;
	}
	public String getBcname() {
		return bcname;
	}
	public void setBcname(String bcname) {
		this.bcname = bcname;
	}
}
