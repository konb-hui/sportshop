package com.zph.sportshop.basedata.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.basedata.dao.UserDao;
import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.query.PageResult;
import com.zph.sportshop.query.basedata.UserQuery;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
}
