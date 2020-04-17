package com.zph.sportshop.good.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.domain.good.Discount;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.domain.privilege.annotation.PrivilegeInfo;
import com.zph.sportshop.good.service.DiscountService;
import com.zph.sportshop.good.service.GoodService;

@Controller("discountAction")
@Scope("prototype")
public class DiscountAction extends BaseAction<Discount>{
	
	@Resource(name="discountService")
	private DiscountService discountService;
	@Resource(name="goodService")
	private GoodService goodService;
	private Long gid;
	private String result;
	
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
	@PrivilegeInfo(name="商品管理")
	public String listDiscount() {
		List<Discount> discounts = this.discountService.listDiscountByGid(this.getGid());
		Good good = this.goodService.getEntry(this.gid);
		ActionContext.getContext().put("discounts", discounts);
		ActionContext.getContext().put("good", good);
		return "listDiscount";
	}
	@PrivilegeInfo(name="商品管理")
	public String updateDiscount() {
		Discount discount1 = this.discountService.findByFullAndReduce(this.getModel().getFullprice(), this.getModel().getReduceprice());
		if(discount1 != null) this.result = "该优惠券已经存在";
		else {
			Discount discount2 = this.discountService.getEntry(this.getModel().getDid());
			discount2.setFullprice(this.getModel().getFullprice());
			discount2.setReduceprice(this.getModel().getReduceprice());
			discountService.updateEntry(discount2);
			this.result = "更新成功";
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String addDiscount() {
		Discount discount1 = this.discountService.findByFullAndReduce(this.getModel().getFullprice(), this.getModel().getReduceprice());
		if(discount1 != null) this.result = "该优惠券已经存在";
		else {
			Discount discount2 = new Discount();
			discount2.setFullprice(this.getModel().getFullprice());
			discount2.setReduceprice(this.getModel().getReduceprice());
			Good good = this.goodService.getEntry(this.getGid());
			discount2.setGood(good);
			this.discountService.saveEntry(discount2);
			this.result = "添加成功";
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String deleteDiscount() {
		this.discountService.deleteEntryById(this.getModel().getDid());
		return SUCCESS;
	}
}
