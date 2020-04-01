package com.zph.sportshop.basedata.action;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.basedata.service.UserService;
import com.zph.sportshop.domain.basedata.Address;
import com.zph.sportshop.domain.basedata.User;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	@Resource(name="userService")
	private UserService userService;
	
	public String information() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return action2action;
		ActionContext.getContext().put("user", user);
		return "information";
	}
	public String update() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		user.setUsername(this.getModel().getUsername());
		user.setEmail(this.getModel().getEmail());
		user.setPhone(this.getModel().getPhone());
		userService.updateEntry(user);
		return SUCCESS;
	}
	public String updatePsw() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		user.setPassword(this.getModel().getPassword());
		userService.updateEntry(user);
		return SUCCESS;
	}
	public String favorite() {
		return "favorite";
	}
	public String address() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		Collection<Address> addressList = userService.getEntry(user.getUid()).getAddresses();
		ActionContext.getContext().put("addressList", addressList);
		return "address";
	}
}
