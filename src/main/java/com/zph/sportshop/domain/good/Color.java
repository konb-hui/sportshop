package com.zph.sportshop.domain.good;

import java.io.Serializable;
import java.util.Set;

import com.zph.sportshop.domain.basedata.ShopCart;

public class Color implements Serializable{
	private Long coid;
	private String coname;
	private Good good;
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public Long getCoid() {
		return coid;
	}
	public void setCoid(Long coid) {
		this.coid = coid;
	}
	public String getConame() {
		return coname;
	}
	public void setConame(String coname) {
		this.coname = coname;
	}
}
