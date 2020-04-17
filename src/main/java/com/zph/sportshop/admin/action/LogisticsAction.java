package com.zph.sportshop.admin.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.admin.service.LogisticsService;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.domain.admin.Logistics;
import com.zph.sportshop.domain.privilege.annotation.PrivilegeInfo;
import com.zph.sportshop.query.PageResult;
import com.zph.sportshop.query.admin.LogisticsQuery;

@Controller("logisticsAction")
@Scope("prototype")
public class LogisticsAction extends BaseAction<Logistics>{
	
	@Resource(name="logisticsService")
	private LogisticsService logisticsService;
	private String result;
	private LogisticsQuery baseQuery = new LogisticsQuery();
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@PrivilegeInfo(name="物流管理")
	public String listLogistics() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setPageSize(6);
		PageResult<Logistics> logisticses = this.logisticsService.findPageResult(baseQuery);
		ActionContext.getContext().put("logisticses", logisticses);
		return "listLogistics";
	}
	@PrivilegeInfo(name="物流管理")
	public String updateLogistics() {
		Logistics logistics1 = this.logisticsService.findByName(this.getModel().getLname());
		if(logistics1 != null) this.result = "该物流已经存在";
		else {
			Logistics logistics2 = this.logisticsService.getEntry(this.getModel().getLid());
			logistics2.setLname(this.getModel().getLname());
			this.logisticsService.updateEntry(logistics2);
			String content = "更新了物流：" + logistics2.getLid();
			this.addInfo(content);
			this.result = "更新成功";
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="物流管理")
	public String addLogistics() {
		Logistics logistics1 = this.logisticsService.findByName(this.getModel().getLname());
		if(logistics1 != null) this.result = "该物流已经存在";
		else {
			Logistics logistics2 = new Logistics();
			logistics2.setLname(this.getModel().getLname());
			this.logisticsService.saveEntry(logistics2);
			String content = "添加了物流：" + logistics2.getLid();
			this.addInfo(content);
			this.result = "添加成功";
		}
		return SUCCESS;
	}
	@PrivilegeInfo(name="物流管理")
	public String deleteLogistics() {
		String content = "更新了物流：" + this.getModel().getLid();
		this.addInfo(content);
		this.logisticsService.deleteEntryById(this.getModel().getLid());
		return SUCCESS;
	}
}
