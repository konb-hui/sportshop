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
import com.zph.sportshop.admin.service.LogisticsService;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.basedata.service.AddressService;
import com.zph.sportshop.basedata.service.HistoryService;
import com.zph.sportshop.basedata.service.MyorderService;
import com.zph.sportshop.basedata.service.ShopCartService;
import com.zph.sportshop.domain.admin.Logistics;
import com.zph.sportshop.domain.basedata.Address;
import com.zph.sportshop.domain.basedata.History;
import com.zph.sportshop.domain.basedata.Myorder;
import com.zph.sportshop.domain.basedata.ShopCart;
import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.domain.privilege.annotation.PrivilegeInfo;
import com.zph.sportshop.good.service.GoodService;
import com.zph.sportshop.query.PageResult;
import com.zph.sportshop.query.basedata.MyorderQuery;

@Controller("myorderAction")
@Scope("prototype")
public class MyorderAction extends BaseAction<Myorder>{
	
	@Resource(name="myorderService")
	private MyorderService myorderService;
	@Resource(name="historyService")
	private HistoryService historyService;
	@Resource(name="shopCartService")
	private ShopCartService shopCartService;
	@Resource(name="addressService")
	private AddressService addressService;
	@Resource(name="logisticsService")
	private LogisticsService logisticsService;
	@Resource(name="goodService")
	private GoodService goodService;
	private MyorderQuery baseQuery = new MyorderQuery();
	private Integer totalPrice;
	private Long aid;
	private Long lid;
	public Long getLid() {
		return lid;
	}

	public void setLid(Long lid) {
		this.lid = lid;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String confirmOrder() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		ActionContext.getContext().put("totalPrice", this.getTotalPrice());
		ActionContext.getContext().put("newPrice", this.getTotalPrice());
		ActionContext.getContext().put("shopcarts", this.shopCartService.getShopCartsByUid(user.getUid()));
		return "confirmorder";
	}
	public String addOrder() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		Myorder myorder = new Myorder();
		List<ShopCart> shopCarts = shopCartService.getShopCartsByUid(user.getUid());
		Set<History> histories = new HashSet<History>();
		for (Iterator iterator = shopCarts.iterator(); iterator.hasNext();) {
			ShopCart shopCart = (ShopCart) iterator.next();
			History h = new History();
			Good good = shopCart.getGood();
			Integer sv = good.getSalesvolume();
			sv++;
			good.setSalesvolume(sv);
			goodService.updateEntry(good);
			h.setGood(shopCart.getGood());
			h.setGoodsnum(shopCart.getGoodsnum());
			h.setShopcolor(shopCart.getShopcolor());
			h.setShopsize(shopCart.getShopsize());
			h.setUser(user);
			historyService.saveEntry(h);
			histories.add(h);
		}
		Address address = addressService.getEntry(this.getAid());
		myorder.setAddress(address);
		myorder.setHistories(histories);
		myorder.setUser(user);
		myorder.setPrice(this.getModel().getPrice());
		myorder.setNewprice(this.getModel().getNewprice());
		myorder.setStatus(this.getModel().getStatus());
		myorderService.saveEntry(myorder);
		for (Iterator iterator = histories.iterator(); iterator.hasNext();) {
			History history = (History) iterator.next();
			history.setMyorder(myorder);
			historyService.saveEntry(history);
		}
		for (Iterator iterator = shopCarts.iterator(); iterator.hasNext();) {
			ShopCart shopCart = (ShopCart) iterator.next();
			shopCartService.deleteEntryById(shopCart.getScid());
		}
		map.put("oid", myorder.getOid());
		return SUCCESS;
	}
	public String addBuyOrder() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		Set<History> histories = new HashSet<History>();
		Myorder myorder = new Myorder();
		ShopCart shopCart = (ShopCart) map.get("shopcart");
		History history = new History();
		Good good = shopCart.getGood();
		Integer sv = good.getSalesvolume();
		sv++;
		good.setSalesvolume(sv);
		this.goodService.updateEntry(good);
		history.setGood(good);
		history.setGoodsnum(shopCart.getGoodsnum());
		history.setShopcolor(shopCart.getShopcolor());
		history.setShopsize(shopCart.getShopsize());
		history.setUser(user);
		this.historyService.saveEntry(history);
		histories.add(history);
		Address address = addressService.getEntry(this.getAid());
		myorder.setAddress(address);
		myorder.setHistories(histories);
		myorder.setUser(user);
		myorder.setPrice(this.getModel().getPrice());
		myorder.setNewprice(this.getModel().getNewprice());
		myorder.setStatus(this.getModel().getStatus());
		this.myorderService.saveEntry(myorder);
		history.setMyorder(myorder);
		this.historyService.saveEntry(history);
		map.put("oid", myorder.getOid());
		map.put("shopcart", null);
		return SUCCESS;
	}
	public String listOrder() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return "login";
		List<Myorder> orderList = myorderService.listOrderByUid(user.getUid());
		ActionContext.getContext().put("orderList", orderList);
		return "listorder";
	}
	public String listOrder2() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return "login";
		List<Myorder> orderList = myorderService.listOrderByUid(user.getUid());
		ActionContext.getContext().put("orderList", orderList);
		return "listorder2";
	}
	public String listOrder3() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return "login";
		List<Myorder> orderList = myorderService.listOrderByUid(user.getUid());
		ActionContext.getContext().put("orderList", orderList);
		return "listorder3";
	}
	public String listOrder4() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return "login";
		List<Myorder> orderList = myorderService.listOrderByUid(user.getUid());
		ActionContext.getContext().put("orderList", orderList);
		return "listorder4";
	}
	@PrivilegeInfo(name="订单管理")
	public String listOrderForAdmin() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setPageSize(6);
		if(this.getModel().getStatus() == null) {
			baseQuery.setStatus("未发货");
			ActionContext.getContext().put("status","未发货");
		}
		else {
			if(this.getModel().getStatus() == "已发货") {
				listReceivedOrder();
			}else if(this.getModel().getStatus() == "已完成") {
				listCompletedOrder();
			}
			baseQuery.setStatus(this.getModel().getStatus());
			ActionContext.getContext().put("status", this.getModel().getStatus());
		}
		if(this.getModel().getOid() != null) baseQuery.setOid(this.getModel().getOid());
		PageResult<Myorder> orders = this.myorderService.findPageResult(baseQuery);
		List<Logistics> logisticses = this.logisticsService.findAll();
		ActionContext.getContext().put("logisticses", logisticses);
		ActionContext.getContext().put("orders", orders);
		return "listOrderForAdmin";
	}
	@PrivilegeInfo(name="订单管理")
	public String changeStatus() {
		Myorder order = this.myorderService.getEntry(this.getModel().getOid());
		String content = "发货了订单：" + order.getOid();
		this.addInfo(content);
		Logistics logistics = this.logisticsService.getEntry(this.lid);
		order.setStatus("已发货");
		order.setLogistics(logistics);
		this.myorderService.updateEntry(order);
		return SUCCESS;
	}
	@PrivilegeInfo(name="订单管理")
	public String listReceivedOrder() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setPageSize(6);
		baseQuery.setStatus("已发货");
		ActionContext.getContext().put("status", "已发货");
		if(this.getModel().getOid() != null) baseQuery.setOid(this.getModel().getOid());
		PageResult<Myorder> orders = this.myorderService.findPageResult(baseQuery);
		ActionContext.getContext().put("orders", orders);
		return "listReceivedOrder";
	}
	@PrivilegeInfo(name="订单管理")
	public String completedOrder() {
		Myorder myorder = this.myorderService.getEntry(this.getModel().getOid());
		myorder.setStatus("已收货");
		this.myorderService.updateEntry(myorder);
		return SUCCESS;
	}
	@PrivilegeInfo(name="订单管理")
	public String listCompletedOrder() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setPageSize(6);
		baseQuery.setStatus("已收货");
		ActionContext.getContext().put("status", "已收货");
		if(this.getModel().getOid() != null) baseQuery.setOid(this.getModel().getOid());
		PageResult<Myorder> orders = this.myorderService.findPageResult(baseQuery);
		ActionContext.getContext().put("orders", orders);
		return "listCompletedOrder";
	}
	public String deleteOrder() {
		List<History> histories = this.historyService.findByOid(this.getModel().getOid());
		for (Iterator iterator = histories.iterator(); iterator.hasNext();) {
			History history = (History) iterator.next();
			history.setMyorder(null);
			this.historyService.updateEntry(history);
		}
		this.myorderService.deleteEntryById(this.getModel().getOid());
		return SUCCESS;
	}
	public String payOrder() {
		Myorder myorder = this.myorderService.getEntry(this.getModel().getOid());
		myorder.setStatus("未发货");
		this.myorderService.updateEntry(myorder);
		return SUCCESS;
	}
	public String toPay() {
		Map map = ActionContext.getContext().getSession();
		Long oid = (Long) map.get("oid");
		if(oid != null) {
			ActionContext.getContext().put("oid", oid);
			ActionContext.getContext().put("money", this.myorderService.getEntry(oid).getNewprice());
			return "pay";
		}
		return SUCCESS;
	}
}
