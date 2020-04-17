package com.zph.sportshop.login.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.login.service.RegisterService;
import com.zph.sportshop.util.encryption.EncryptionPsw;
import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;

@Controller("registerAction")
@Scope("prototype")
public class RegisterAction extends BaseAction<User>{
	
	@Resource(name="registerService")
	private RegisterService registerService;
	
	public String checkRegister() {
		Boolean checkAccount = this.registerService.isExistAccount(this.getModel().getAccount());
		Boolean checkUsername = this.registerService.isExistUsername(this.getModel().getUsername());
		if((!checkAccount)||(!checkUsername)) {
			if(!checkAccount) {
				ActionContext.getContext().put("errorMsg", "账号已存在");
			}else if(!checkUsername) {
				ActionContext.getContext().put("errorMsg", "昵称已存在");
			}
			ActionContext.getContext().getValueStack().push(this.getModel());
			return action2action;
		}else if(this.getModel().getAccount() != null &&
				this.getModel().getPassword() != null &&
				this.getModel().getUsername() != null){
			User user = new User();
			user = this.getModel();
			user.setPassword(EncryptionPsw.getPassword(this.getModel().getPassword()));
			registerService.addUser(user);
		     Map session = ActionContext.getContext().getSession();  
		     session.put("user", user);
			return "homepage";
		}else return action2action;
	}
	public String register() {
		return "register";
	}
}
