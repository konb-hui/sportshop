package com.zph.sportshop.admin.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zph.sportshop.admin.dao.AdminDao;
import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.admin.Admin;

@Repository("adminDao")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public Admin findByNameAndPsw(String adminName, String password) {
		// TODO Auto-generated method stub
		List<Admin> admins = this.hibernateTemplate.find("from Admin where adminName = ? and password = ?",adminName,password);
		if(admins.size() == 0) return null;
		else return admins.get(0);
	}

	public Admin findByName(String adminName) {
		// TODO Auto-generated method stub
		List<Admin> admins = this.hibernateTemplate.find("from Admin where adminName=?",adminName);
		if(admins.size() != 0) return admins.get(0);
		else
		return null;
	}

}
