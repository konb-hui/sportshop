package com.zph.sportshop.login.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.login.dao.LoginDao;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public User checkLogin(String account, String password) {
		// TODO Auto-generated method stub
		List<User> users = this.hibernateTemplate.find("from User where account=? and password=?",account,password);
		if(users.size()==0) {
			return null;
		}else {
			return users.get(0);
		}
	}
	

}
