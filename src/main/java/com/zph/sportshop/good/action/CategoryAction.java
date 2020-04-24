package com.zph.sportshop.good.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.domain.good.Category;
import com.zph.sportshop.domain.privilege.annotation.PrivilegeInfo;
import com.zph.sportshop.good.service.CategoryService;
import com.zph.sportshop.query.BaseQuery;
import com.zph.sportshop.query.PageResult;
import com.zph.sportshop.query.good.CategoryQuery;

@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>{
	
	@Resource(name="categoryService")
	private CategoryService categoryService;
	private CategoryQuery baseQuery  = new CategoryQuery();
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@PrivilegeInfo(name="商品类别管理")
	public String listCategory() {
		baseQuery.setPageSize(6);
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<Category> categories;
		if(this.getKey() != null) {
			baseQuery.setKey(this.getKey());
			categories = categoryService.findPageResultByKey(baseQuery);
			ActionContext.getContext().put("key", this.getKey());
		}else {
			categories = categoryService.findPageResult(baseQuery);
		}
		ActionContext.getContext().put("categories", categories);
		return "listCategory";
	}
	@PrivilegeInfo(name="商品类别管理")
	public String updateCategory() {
		Category category1 = this.categoryService.findByName(this.getModel().getCname());
		if(category1 != null) {
			this.result = "存在相同的类名";
		}else {
			Category category2 = this.categoryService.getEntry(this.getModel().getCid());
			String content = "更新了商品类别：（" + category2.getCname() + "）为（" + this.getModel().getCname() + "）";
			this.addInfo(content);
			category2.setCname(this.getModel().getCname());
			this.categoryService.updateEntry(category2);
			this.result = "更新成功";
			ActionContext.getContext().put("result", result);
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品类别管理")
	public String addCategory() {
		Category category1 = this.categoryService.findByName(this.getModel().getCname());
		if(category1 != null) {
			this.result = "存在相同的类名";
		}else {
			Category category2 = new Category();
			category2.setCname(this.getModel().getCname());
			this.categoryService.saveEntry(category2);
			this.result = "添加成功";
			ActionContext.getContext().put("result", result);
			String content = "增加了商品类别：" + category2.getCname();
			this.addInfo(content);
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="商品类别管理")
	public String deleteCategory() {
		String content = "删除了商品类别：" + this.getModel().getCid();
		this.addInfo(content);
		categoryService.deleteEntryById(this.getModel().getCid());
		return SUCCESS;
	}
}
