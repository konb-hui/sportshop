package com.zph.sportshop.basedata.action;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.basedata.service.UserService;
import com.zph.sportshop.domain.basedata.User;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	@Resource(name="userService")
	private UserService userService;
	
}
