package com.zph.sportshop.domain.good;

import java.io.Serializable;
import java.util.Set;

import com.zph.sportshop.domain.basedata.ShopCart;

public class Size implements Serializable{
	private Long sid;
	private String sname;
	private Integer num = 0;
	private Good good;
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
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
