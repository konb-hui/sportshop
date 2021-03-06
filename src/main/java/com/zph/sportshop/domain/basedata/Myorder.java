package com.zph.sportshop.domain.basedata;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import com.zph.sportshop.domain.admin.Logistics;

public class Myorder implements Serializable{
	private Long oid;
	private Double price;
	private Double newprice;
	private Date time;
	private User user;
	private Set<History> histories;
	private String status;
	private String address;
	private String consignee;
	private String phone;
	private Logistics logistics;
	public Logistics getLogistics() {
		return logistics;
	}
	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<History> getHistories() {
		return histories;
	}
	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getNewprice() {
		return newprice;
	}
	public void setNewprice(Double newprice) {
		this.newprice = newprice;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
