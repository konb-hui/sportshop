package com.zph.sportshop.login.service;

import com.zph.sportshop.domain.basedata.User;

public interface RegisterService {
	public boolean isExistAccount(String account);
	public boolean isExistUsername(String username);
	public void addUser(User user);
}
