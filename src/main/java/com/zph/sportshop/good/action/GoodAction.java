package com.zph.sportshop.good.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.good.service.GoodService;

@Controller("goodAction")
@Scope("prototype")
public class GoodAction {
	
	@Resource(name="goodService")
	private GoodService goodService;
}
