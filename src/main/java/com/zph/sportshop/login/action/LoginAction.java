package com.zph.sportshop.login.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.login.service.LoginService;
import com.zph.sportshop.util.encryption.EncryptionPsw;
import com.zph.sportshop.util.verificate.Verificate;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User>{
	
	@Resource(name="loginService")
	private LoginService loginService;
	private String confirmlogo;
	
	public String getConfirmlogo() {
		return confirmlogo;
	}
	public void setConfirmlogo(String confirmlogo) {
		this.confirmlogo = confirmlogo;
	}
	public String checkLogin() {
		Map map = ActionContext.getContext().getSession();
		String codeStr = (String) map.get("codeStr");
		User saveUser = (User) map.get("user");
		if(saveUser != null) return "homepage";
		String account = this.getModel().getAccount();
		String password = EncryptionPsw.getPassword(this.getModel().getPassword());
		if(!codeStr.equals(confirmlogo)) {
			ActionContext.getContext().put("account", account);
			ActionContext.getContext().put("password", this.getModel().getPassword());
			ActionContext.getContext().put("errorMsg", "验证码错误");
			return "login";
		}else {
			User user = loginService.checkLogin(account, password);
			if(user == null) {
				ActionContext.getContext().put("errorMsg", "账号或密码错误");
				return "login";
			}else {
			     Map session = ActionContext.getContext().getSession();  
			     session.put("user", user);
				return "homepage";
			}
		}
	}
	public void getVerificationcodeimg() {
		Verificate verificate = new Verificate();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("image/png");
		response.setHeader("cache", "no-cache");
		try {
			OutputStream out = response.getOutputStream();
			String codeStr = verificate.getCertPic(0, 0, out);
		     Map session = ActionContext.getContext().getSession();  
		     session.put("codeStr", codeStr);  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String login() {
		
		return "login";
	}
	public String logout() {
		ActionContext.getContext().getSession().clear(); 
		return "login";
	}
}
