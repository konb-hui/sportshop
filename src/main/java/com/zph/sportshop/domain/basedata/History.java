package com.zph.sportshop.domain.basedata;

import java.io.Serializable;
import java.sql.Date;

import com.zph.sportshop.domain.good.Good;

public class History implements Serializable{
	private Long hid;
	private Integer goodsnum;
	private String shopcolor;
	private String shopsize;
	private Good good;
	private User user;
	private Myorder myorder;
	private Date addtime;
	private String iscomment;
	public String getIscomment() {
		return iscomment;
	}
	public void setIscomment(String iscomment) {
		this.iscomment = iscomment;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getHid() {
		return hid;
	}
	public void setHid(Long hid) {
		this.hid = hid;
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
	public Myorder getMyorder() {
		return myorder;
	}
	public void setMyorder(Myorder myorder) {
		this.myorder = myorder;
	}
}
