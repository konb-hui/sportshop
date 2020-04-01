package com.zph.sportshop.login.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zph.sportshop.login.dao.RegisterDao;
import com.zph.sportshop.domain.basedata.User;

@Repository("registerDao")
public class RegisterDaoImpl implements RegisterDao{
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public boolean isExistAccount(String account) {
		// TODO Auto-generated method stub
		List<User> users = this.hibernateTemplate.find("from User where account=?",account);
		if(users.size() == 0) return true;
		else return false;
	}

	public boolean isExistUsername(String username) {
		// TODO Auto-generated method stub
		List<User> users = this.hibernateTemplate.find("from User where username=?",username);
		if(users.size() == 0) return true;
		else return false;
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(user);
	}

}
