package com.zph.sportshop.basedata.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.basedata.dao.UserDao;
import com.zph.sportshop.basedata.service.UserService;
import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.userDao;
	}

}
