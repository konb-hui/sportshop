package com.zph.sportshop.basedata.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.basedata.service.HistoryService;
import com.zph.sportshop.domain.basedata.History;

@Controller("historyAction")
@Scope("prototype")
public class HistoryAction extends BaseAction<History>{
	
	@Resource(name="historyService")
	private HistoryService historyService;
	
}
