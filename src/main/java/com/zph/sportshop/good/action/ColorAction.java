package com.zph.sportshop.good.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.domain.good.Color;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.domain.privilege.annotation.PrivilegeInfo;
import com.zph.sportshop.good.service.GoodService;
import com.zph.sportshop.good.service.ColorService;

@Controller("colorAction")
@Scope("prototype")
public class ColorAction extends BaseAction<Color>{
	
	@Resource(name="colorService")
	private ColorService colorService;
	@Resource(name="goodService")
	private GoodService goodService;
	private Long gid;
	private String result;
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@PrivilegeInfo(name="商品管理")
	public String listColor() {
		List<Color> colors = this.colorService.findColorByGid(this.getGid());
		Good good = this.goodService.getEntry(this.getGid());
		ActionContext.getContext().put("colors", colors);
		ActionContext.getContext().put("good", good);
		return "listColor";
	}
	@PrivilegeInfo(name="商品管理")
	public String updateColor() {
			Color color2 = this.colorService.getEntry(this.getModel().getCoid());
			color2.setConame(this.getModel().getConame());
			colorService.updateEntry(color2);
			this.result = "更新成功";
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String addColor() {
			Color color2 = new Color();
			color2.setConame(this.getModel().getConame());
			Good good = this.goodService.getEntry(this.getGid());
			color2.setGood(good);
			colorService.saveEntry(color2);
			this.result = "添加成功";
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String deleteColor() {
		this.colorService.deleteEntryById(this.getModel().getCoid());
		return SUCCESS;
	}
}
