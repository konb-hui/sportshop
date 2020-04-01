package com.zph.sportshop.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.login.dao.LoginDao;
import com.zph.sportshop.login.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource(name="loginDao")
	private LoginDao loginDao;
	
	public User checkLogin(String account, String password) {
		// TODO Auto-generated method stub
		return loginDao.checkLogin(account, password);
	}

}
