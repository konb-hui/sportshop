package com.zph.sportshop.basedata.action;

import java.util.HashMap;
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
import com.zph.sportshop.good.service.SizeService;

@Controller("shopCartAction")
@Scope("prototype")
public class ShopCartAction extends BaseAction<ShopCart>{
	
	@Resource(name="shopCartService")
	private ShopCartService shopCartService;
	@Resource(name="goodService")
	private GoodService goodService;
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="sizeService")
	private SizeService sizeService;
	private Long gid;
	private Map<String, Object> cart = new HashMap<String, Object>();
	private String result;
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Map<String, Object> getCart() {
		return cart;
	}

	public void setCart(Map<String, Object> cart) {
		this.cart = cart;
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
			this.result="请登录";
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
		shopCart.setGood(goodService.getEntry(this.getGid()));
		shopCart.setUser(user);
		shopCart.setShopcolor(this.getModel().getShopcolor());
		shopCart.setShopsize(this.getModel().getShopsize());
		shopCart.setGoodsnum(this.getModel().getGoodsnum());
		shopCartService.saveEntry(shopCart);
		ActionContext.getContext().put("addShopCart", "添加成功");
		this.result = "添加成功";
		return SUCCESS;
	}
	public String addBuy() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		ShopCart shopCart2 = (ShopCart) map.get("shopcart");
		if(user == null) {
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
		shopCart.setGood(goodService.getEntry(this.getGid()));
		shopCart.setUser(user);
		shopCart.setShopcolor(this.getModel().getShopcolor());
		shopCart.setShopsize(this.getModel().getShopsize());
		shopCart.setGoodsnum(this.getModel().getGoodsnum());
		map.put("shopcart", shopCart);
		return SUCCESS;
	}
	public String confirmBuy() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return "login";
		ShopCart shopCart = (ShopCart) map.get("shopcart");
		ActionContext.getContext().put("shopcart", shopCart);
		ActionContext.getContext().put("user", this.userService.getEntry(user.getUid()));
		return "confirmBuy";
	}
	public String showShopCart() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		this.cart.put("shopcart", this.shopCartService.getShopCartsByUid(user.getUid()));
		this.cart.put("vip", user.getIsvip());
		return "showcart";
	}
	public String goCart() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return "login";
		this.cart.put("shopcart", this.shopCartService.getShopCartsByUid(user.getUid()));
		this.cart.put("vip", user.getIsvip());
		ActionContext.getContext().put("shopcarts", cart);
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
	public String getNum() {
		this.result = this.sizeService.getByGidAndName(this.gid, this.getModel().getShopsize()).getNum().toString();
		return SUCCESS;
	}
}
