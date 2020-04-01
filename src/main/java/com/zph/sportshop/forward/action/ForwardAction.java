package com.zph.sportshop.forward.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zph.sportshop.base.action.BaseAction;

@Controller("forwardAction")
@Scope("prototype")
public class ForwardAction extends ActionSupport{
	public String admin() {
		return "admin";
	}
}
