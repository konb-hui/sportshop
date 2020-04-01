package com.zph.sportshop.domain.good;

import java.io.Serializable;
import java.util.Set;

public class Color implements Serializable{
	private Long coid;
	private String coname;
	private Set<Good> goods;
	public Set<Good> getGoods() {
		return goods;
	}
	public void setGoods(Set<Good> goods) {
		this.goods = goods;
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
