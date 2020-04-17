package com.zph.sportshop.domain.basedata;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import com.zph.sportshop.domain.good.Comment;
import com.zph.sportshop.domain.good.Discount;
import com.zph.sportshop.domain.good.Good;

public class User implements Serializable{
	private Long uid;
	private String username;
	private String password;
	private String account;
	private String sex;
	private String email;
	private String phone;
	private String isvip = "否";
	private Date regTime;
	private Date buyTime;
	private Date endTime;
	private Set<Address> addresses;
	private Set<Good> favoritegoods;
	private Set<Comment> comments;
	private Set<ShopCart> shopCarts;
	private Set<Discount> discounts;
	private Set<Myorder> myorders;
	private Set<History> histories;
	public Set<History> getHistories() {
		return histories;
	}
	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}
	public Set<Myorder> getMyorders() {
		return myorders;
	}
	public void setMyorders(Set<Myorder> myorders) {
		this.myorders = myorders;
	}
	public Set<Discount> getDiscounts() {
		return discounts;
	}
	public void setDiscounts(Set<Discount> discounts) {
		this.discounts = discounts;
	}
	public Set<ShopCart> getShopCarts() {
		return shopCarts;
	}
	public void setShopCarts(Set<ShopCart> shopCarts) {
		this.shopCarts = shopCarts;
	}
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Set<Good> getFavoritegoods() {
		return favoritegoods;
	}
	public void setFavoritegoods(Set<Good> favoritegoods) {
		this.favoritegoods = favoritegoods;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIsvip() {
		return isvip;
	}
	public void setIsvip(String isvip) {
		this.isvip = isvip;
	}
	
}
