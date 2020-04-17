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
		ActionContext.getContext().put("totalPrice", this.getTotalPrice());
		ActionContext.getContext().put("newPrice", this.getTotalPrice());
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
	@PrivilegeInfo(name="订单管理")
	public String listOrderForAdmin() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setPageSize(6);
		if(this.getModel().getStatus() == null) baseQuery.setStatus("未发货");
		else
		baseQuery.setStatus(this.getModel().getStatus());
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
	public String listReceivedOrder() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setPageSize(6);
		baseQuery.setStatus("已发货");
		PageResult<Myorder> orders = this.myorderService.findPageResult(baseQuery);
		ActionContext.getContext().put("orders", orders);
		return "listReceivedOrder";
	}
	public String completedOrder() {
		Myorder myorder = this.myorderService.getEntry(this.getModel().getOid());
		myorder.setStatus("已收货");
		this.myorderService.updateEntry(myorder);
		return SUCCESS;
	}
	public String listCompletedOrder() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setPageSize(6);
		baseQuery.setStatus("已收货");
		PageResult<Myorder> orders = this.myorderService.findPageResult(baseQuery);
		ActionContext.getContext().put("orders", orders);
		return "listCompletedOrder";
	}
}
