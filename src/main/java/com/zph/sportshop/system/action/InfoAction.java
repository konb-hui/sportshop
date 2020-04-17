package com.zph.sportshop.system.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.domain.system.Info;
import com.zph.sportshop.query.PageResult;
import com.zph.sportshop.query.system.InfoQuery;
import com.zph.sportshop.system.service.InfoService;

@Controller("infoAction")
@Scope("prototype")
public class InfoAction extends BaseAction<Info>{
	
	@Resource(name="infoService")
	private InfoService infoService;
	private InfoQuery baseQuery = new InfoQuery();
	private Long adminId;
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String listInfo() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		baseQuery.setAdminId(this.adminId);
		baseQuery.setPageSize(10);
		PageResult<Info> infos = this.infoService.findPageResult(baseQuery);
		ActionContext.getContext().put("infos", infos);
		return "listInfo";
	}
}
