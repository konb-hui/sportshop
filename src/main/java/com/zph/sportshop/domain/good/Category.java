package com.zph.sportshop.domain.good;

import java.io.Serializable;
import java.util.Set;

public class Category implements Serializable{
	private Long cid;
	private String cname;
	private Set<Good> goods;
	public Set<Good> getGoods() {
		return goods;
	}
	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
