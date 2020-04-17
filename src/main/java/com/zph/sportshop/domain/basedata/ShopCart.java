package com.zph.sportshop.domain.basedata;

import java.util.Set;

import com.zph.sportshop.domain.good.Color;
import com.zph.sportshop.domain.good.Discount;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.domain.good.Size;

public class ShopCart {
	private Long scid;
	private Integer goodsnum;
	private String shopcolor;
	private String shopsize;
	private Good good;
	private User user;
	private Set<Discount> discounts;
	public Set<Discount> getDiscounts() {
		return discounts;
	}
	public void setDiscounts(Set<Discount> discounts) {
		this.discounts = discounts;
	}
	public Integer getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(Integer goodsnum) {
		this.goodsnum = goodsnum;
	}
	public String getShopcolor() {
		return shopcolor;
	}
	public void setShopcolor(String shopcolor) {
		this.shopcolor = shopcolor;
	}
	public String getShopsize() {
		return shopsize;
	}
	public void setShopsize(String shopsize) {
		this.shopsize = shopsize;
	}
	public Long getScid() {
		return scid;
	}
	public void setScid(Long scid) {
		this.scid = scid;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
