package com.zph.sportshop.basedata.action;

import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.basedata.service.UserService;
import com.zph.sportshop.domain.basedata.Address;
import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.domain.good.Discount;
import com.zph.sportshop.domain.privilege.annotation.PrivilegeInfo;
import com.zph.sportshop.good.service.DiscountService;
import com.zph.sportshop.good.service.GoodService;
import com.zph.sportshop.query.PageResult;
import com.zph.sportshop.query.basedata.UserQuery;
import com.zph.sportshop.util.encryption.EncryptionPsw;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="goodService")
	private GoodService goodService;
	@Resource(name="discountService")
	private DiscountService discountService;
	private Integer monthnum;
	private String result;
	private Long did;
	private UserQuery baseQuery = new UserQuery();
	private String oldPsw;
	private String newPsw;
	public String getOldPsw() {
		return oldPsw;
	}
	public void setOldPsw(String oldPsw) {
		this.oldPsw = oldPsw;
	}
	public String getNewPsw() {
		return newPsw;
	}
	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getMonthnum() {
		return monthnum;
	}
	public void setMonthnum(Integer monthnum) {
		this.monthnum = monthnum;
	}
	public String information() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return action2action;
		ActionContext.getContext().put("user", user);
		return "information";
	}
	public String update() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		user.setUsername(this.getModel().getUsername());
		user.setEmail(this.getModel().getEmail());
		user.setPhone(this.getModel().getPhone());
		userService.updateEntry(user);
		return SUCCESS;
	}
	public String updatePsw() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(!user.getPassword().equals(EncryptionPsw.getPassword(this.oldPsw))) {
			this.result="旧密码错误";
		}else {
			user.setPassword(EncryptionPsw.getPassword(this.newPsw));
			userService.updateEntry(user);
			this.result = "更新成功";
		}
		return SUCCESS;
	}
	public String address() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		Collection<Address> addressList = userService.getEntry(user.getUid()).getAddresses();
		ActionContext.getContext().put("addressList", addressList);
		return "address";
	}
	public String listFavorite() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return action2action;
		ActionContext.getContext().put("goods", user.getFavoritegoods());
		return "listfavorite";
	}
	public String VIP() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return action2action;
		boolean isVip = true;
		if(user.getIsvip().equals("否")) isVip = false;
		else ActionContext.getContext().put("user", user);
		ActionContext.getContext().put("isVip", isVip);
		return "gotovip";
	}
	public String becomeVip() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		Calendar c = Calendar.getInstance();
		user.setBuyTime(new java.sql.Date(c.getTimeInMillis()));
		c.add(Calendar.DATE, 30*this.getMonthnum());
		user.setEndTime(new java.sql.Date(c.getTimeInMillis()));
		user.setIsvip("是");
		userService.updateEntry(user);
		return SUCCESS;
	}
	public String renewVip() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(user.getEndTime().getTime());
		c.add(Calendar.DATE, 30);
		user.setEndTime(new java.sql.Date(c.getTimeInMillis()));
		userService.updateEntry(user);
		return SUCCESS;
	}
	public String addDiscount() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user.getDiscounts() != null) {
			for (Iterator iterator = user.getDiscounts().iterator(); iterator.hasNext();) {
				Discount discount = (Discount) iterator.next();
				if(discount.getDid() == this.getDid()) {
					this.setResult("领取失败");
					return SUCCESS;
				}
			}
		}
		Set<Discount> discounts;
		if(user.getDiscounts() == null) {
			discounts = new HashSet<Discount>();
		}else discounts = user.getDiscounts();
		discounts.add(discountService.getEntry(this.getDid()));
		user.setDiscounts(discounts);
		userService.updateEntry(user);
		this.setResult("领取成功");
		return SUCCESS;
	}
	@PrivilegeInfo(name="用户管理")
	public String userManage() {
		if(this.getKey() != null) searchByKey();
		baseQuery.setPageSize(6);
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setSex(this.getModel().getSex());
		if(this.getModel().getSex() != null) ActionContext.getContext().put("sex", this.getModel().getSex());
		PageResult<User> users = this.userService.findPageResult(baseQuery);
		ActionContext.getContext().put("users", users);
		return "manageUser";
	}
	@PrivilegeInfo(name="用户管理")
	public String searchByKey() {
		baseQuery.setPageSize(6);
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setKey(this.getKey());
		if(this.getKey() != null) ActionContext.getContext().put("key", this.getKey());
		PageResult<User> users = this.userService.findPageResultByKey(baseQuery);
		ActionContext.getContext().put("users", users);
		return "manageUser";
	}
	@PrivilegeInfo(name="用户管理")
	public String deleteByUid() {
		User user = this.userService.getEntry(this.getModel().getUid());
		String content = "删除了用户：" + user.getUsername();
		this.addInfo(content);
		userService.deleteEntryById(this.getModel().getUid());
		return SUCCESS;
	}
}
