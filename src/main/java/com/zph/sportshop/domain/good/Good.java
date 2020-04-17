package com.zph.sportshop.domain.good;

import java.io.Serializable;
import java.util.Set;

import com.zph.sportshop.domain.basedata.History;
import com.zph.sportshop.domain.basedata.ShopCart;
import com.zph.sportshop.domain.basedata.User;

public class Good implements Serializable{
	private Long gid;
	private Integer salesvolume=0;
	private String gname;
	private String images;
	private Double price;
	private Double vipPrice;
	private Category category;
	private Brand brand;
	private Set<Color> colors;
	private Set<Size> sizes;
	private Set<Discount> discounts;
	private Set<User> favoriteusers;
	private Set<Comment> comments;
	private Set<ShopCart> shopCarts;
	private Set<History> histories;
	public Set<History> getHistories() {
		return histories;
	}
	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}
	public Set<ShopCart> getShopCarts() {
		return shopCarts;
	}
	public void setShopCarts(Set<ShopCart> shopCarts) {
		this.shopCarts = shopCarts;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Integer getSalesvolume() {
		return salesvolume;
	}
	public void setSalesvolume(Integer salesvolume) {
		this.salesvolume = salesvolume;
	}
	public Set<User> getFavoriteusers() {
		return favoriteusers;
	}
	public void setFavoriteusers(Set<User> favoriteusers) {
		this.favoriteusers = favoriteusers;
	}
	public Set<Discount> getDiscounts() {
		return discounts;
	}
	public void setDiscounts(Set<Discount> discounts) {
		this.discounts = discounts;
	}
	public Set<Color> getColors() {
		return colors;
	}
	public void setColors(Set<Color> colors) {
		this.colors = colors;
	}
	public Set<Size> getSizes() {
		return sizes;
	}
	public void setSizes(Set<Size> sizes) {
		this.sizes = sizes;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getVipPrice() {
		return vipPrice;
	}
	public void setVipPrice(Double vipPrice) {
		this.vipPrice = vipPrice;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
