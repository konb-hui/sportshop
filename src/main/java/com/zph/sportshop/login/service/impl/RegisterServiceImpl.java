package com.zph.sportshop.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.login.dao.RegisterDao;
import com.zph.sportshop.login.service.RegisterService;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{	
	
	@Resource(name="registerDao")
	private RegisterDao registerDao;
	
	public boolean isExistAccount(String account) {
		// TODO Auto-generated method stub
		return registerDao.isExistAccount(account);
	}

	public boolean isExistUsername(String username) {
		// TODO Auto-generated method stub
		return registerDao.isExistUsername(username);
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		registerDao.addUser(user);
	}

}
