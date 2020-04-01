package com.zph.sportshop.domain.good;

import java.io.Serializable;
import java.util.Set;

public class Brand implements Serializable{
	private int bid;
	private String bname;
	private Set<Good> goods;
	public Set<Good> getGoods() {
		return goods;
	}
	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
}
