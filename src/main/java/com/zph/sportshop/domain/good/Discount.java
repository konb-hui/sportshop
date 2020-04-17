package com.zph.sportshop.domain.good;

import java.io.Serializable;
import java.util.Set;

import com.zph.sportshop.domain.basedata.ShopCart;
import com.zph.sportshop.domain.basedata.User;

public class Discount implements Serializable{
	private Long did;
	private Double fullprice;
	private Double reduceprice;
	private Good good;
	private Set<User> users;
	private Set<ShopCart> shopCarts;
	
	public Set<ShopCart> getShopCarts() {
		return shopCarts;
	}
	public void setShopCarts(Set<ShopCart> shopCarts) {
		this.shopCarts = shopCarts;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public Double getFullprice() {
		return fullprice;
	}
	public void setFullprice(Double fullprice) {
		this.fullprice = fullprice;
	}
	public Double getReduceprice() {
		return reduceprice;
	}
	public void setReduceprice(Double reduceprice) {
		this.reduceprice = reduceprice;
	}
}
