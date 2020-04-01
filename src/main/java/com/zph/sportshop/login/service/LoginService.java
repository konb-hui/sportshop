package com.zph.sportshop.login.service;

import com.zph.sportshop.domain.basedata.User;

public interface LoginService {
	public User checkLogin(String account,String password);
}
