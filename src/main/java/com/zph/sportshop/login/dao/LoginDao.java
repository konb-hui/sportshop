package com.zph.sportshop.login.dao;

import com.zph.sportshop.domain.basedata.User;

public interface LoginDao {
	public User checkLogin(String account,String password);
}
