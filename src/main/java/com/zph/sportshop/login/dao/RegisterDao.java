package com.zph.sportshop.login.dao;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.basedata.User;

public interface RegisterDao{
	public boolean isExistAccount(String account);
	public boolean isExistUsername(String username);
	public void addUser(User user);
}
