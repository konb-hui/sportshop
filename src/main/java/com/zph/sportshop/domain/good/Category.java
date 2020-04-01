package com.zph.sportshop.domain.good;

import java.io.Serializable;
import java.util.Set;

public class Category implements Serializable{
	private int cid;
	private String cname;
	private BigCategory bigCategory;
	private Set<Good> goods;
	public BigCategory getBigCategory() {
		return bigCategory;
	}
	public void setBigCategory(BigCategory bigCategory) {
		this.bigCategory = bigCategory;
	}
	public Set<Good> getGoods() {
		return goods;
	}
	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
