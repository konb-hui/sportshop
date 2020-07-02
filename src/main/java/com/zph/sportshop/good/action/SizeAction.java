package com.zph.sportshop.good.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.domain.good.Size;
import com.zph.sportshop.domain.privilege.annotation.PrivilegeInfo;
import com.zph.sportshop.good.service.GoodService;
import com.zph.sportshop.good.service.SizeService;

@Controller("sizeAction")
@Scope("prototype")
public class SizeAction extends BaseAction<Size>{
	
	@Resource(name="sizeService")
	private SizeService sizeService;
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
	public String listSize() {
		List<Size> sizes = this.sizeService.findSizeByGid(this.gid);
		Good good = this.goodService.getEntry(this.gid);
		ActionContext.getContext().put("sizes", sizes);
		ActionContext.getContext().put("good", good);
		return "listSize";
	}
	@PrivilegeInfo(name="商品管理")
	public String updateSize() {
			Size size2 = this.sizeService.getEntry(this.getModel().getSid());
			size2.setSname(this.getModel().getSname());
			size2.setNum(this.getModel().getNum());
			sizeService.updateEntry(size2);
			this.result = "更新成功";
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String addSize() {
			Size size2 = new Size();
			size2.setSname(this.getModel().getSname());
			size2.setNum(this.getModel().getNum());
			Good good = this.goodService.getEntry(this.gid);
			size2.setGood(good);
			sizeService.saveEntry(size2);
			this.result = "添加成功";
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品管理")
	public String deleteSize() {
		this.sizeService.deleteEntryById(this.getModel().getSid());
		return SUCCESS;
	}
}
