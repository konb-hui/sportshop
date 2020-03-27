package com.zph.sportshop.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.basedata.dao.UserDao;
import com.zph.sportshop.domain.basedata.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

}
