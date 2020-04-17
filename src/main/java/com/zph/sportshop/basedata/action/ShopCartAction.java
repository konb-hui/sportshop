package com.zph.sportshop.basedata.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.basedata.service.ShopCartService;
import com.zph.sportshop.basedata.service.UserService;
import com.zph.sportshop.domain.basedata.ShopCart;
import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.domain.good.Discount;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.good.service.GoodService;

@Controller("shopCartAction")
@Scope("prototype")
public class ShopCartAction extends BaseAction<ShopCart>{
	
	@Resource(name="shopCartService")
	private ShopCartService shopCartService;
	@Resource(name="goodService")
	private GoodService goodService;
	@Resource(name="userService")
	private UserService userService;
	private Long gid;
	private String result;
	private List<ShopCart> cart;
	public List<ShopCart> getCart() {
		return cart;
	}

	public void setCart(List<ShopCart> cart) {
		this.cart = cart;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public String addCart() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) {
			this.setResult("请登录");
			return SUCCESS;
		}
		ShopCart shopCart = new ShopCart();
		if(user.getDiscounts() != null) {
			Set<Discount> discounts = new HashSet<Discount>();
			for (Iterator iterator = user.getDiscounts().iterator(); iterator.hasNext();) {
				Discount discount = (Discount) iterator.next();
				if(discount.getGood().getGid() == this.getGid()) discounts.add(discount);
			}
			shopCart.setDiscounts(discounts);
		}
		System.out.println("asdasd");
		shopCart.setGood(goodService.getEntry(this.getGid()));
		shopCart.setUser(user);
		shopCart.setShopcolor(this.getModel().getShopcolor());
		shopCart.setShopsize(this.getModel().getShopsize());
		shopCart.setGoodsnum(this.getModel().getGoodsnum());
		shopCartService.saveEntry(shopCart);
		ActionContext.getContext().put("addShopCart", "添加成功");
		this.setResult("添加成功！");
		return SUCCESS;
	}
	public String showShopCart() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		User u = userService.getEntry(user.getUid());
		map.put("user", u);
		this.cart = this.shopCartService.getShopCartsByUid(user.getUid());
		return "showcart";
	}
	public String goCart() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return "login";
		return "gocart";
	}
	public String updateNum() {
		ShopCart shopCart = shopCartService.getEntry(this.getModel().getScid());
		shopCart.setGoodsnum(this.getModel().getGoodsnum());
		shopCartService.updateEntry(shopCart);
		return SUCCESS;
	}
	public String deleteCart() {
		shopCartService.deleteEntryById(this.getModel().getScid());
		return SUCCESS;
	}
}
