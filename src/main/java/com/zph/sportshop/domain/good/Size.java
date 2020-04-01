package com.zph.sportshop.domain.good;

import java.io.Serializable;
import java.util.Set;

public class Size implements Serializable{
	private Long sid;
	private String sname;
	private Set<Good> goods;
	public Set<Good> getGoods() {
		return goods;
	}
	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
}
