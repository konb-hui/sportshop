package com.zph.sportshop.good.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.domain.good.Brand;
import com.zph.sportshop.domain.privilege.annotation.PrivilegeInfo;
import com.zph.sportshop.good.service.BrandService;
import com.zph.sportshop.query.PageResult;
import com.zph.sportshop.query.good.BrandQuery;

@Controller("brandAction")
@Scope("prototype")
public class BrandAction extends BaseAction<Brand>{
	
	@Resource(name="brandService")
	private BrandService brandService;
	private BrandQuery baseQuery = new BrandQuery();
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	@PrivilegeInfo(name="品牌管理")
	public String listBrand() {
		baseQuery.setPageSize(6);
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setBname(this.getModel().getBname());
		PageResult<Brand> brands = this.brandService.findPageResult(baseQuery);
		ActionContext.getContext().put("brands", brands);
		return "listBrand";
	}
	@PrivilegeInfo(name="品牌管理")
	public String updateBrand() {
		Brand brand1 = this.brandService.findByName(this.getModel().getBname());
		if(brand1 != null) this.result="该品牌名已经存在";
		else {
			Brand brand2 = this.brandService.getEntry(this.getModel().getBid());
			String content = "更新了品牌：（" + brand2.getBname() + "）为（" + this.getModel().getBname() + "）";
			this.addInfo(content);
			brand2.setBname(this.getModel().getBname());
			this.brandService.updateEntry(brand2);
			this.result="更新成功";
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="品牌管理")
	public String addBrand() {
		Brand brand1 = this.brandService.findByName(this.getModel().getBname());
		if(brand1 != null) this.result = "该品牌名已经存在";
		else {
			Brand brand2 = new Brand();
			brand2.setBname(this.getModel().getBname());
			this.brandService.saveEntry(brand2);
			this.result = "添加成功";
			String content = "增加了品牌：" + brand2.getBname();
			this.addInfo(content);
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="品牌管理")
	public String deleteBrand() {
		String content = "删除了品牌：" + this.getModel().getBid();
		this.addInfo(content);
		this.brandService.deleteEntryById(this.getModel().getBid());
		return SUCCESS;
	}
}
