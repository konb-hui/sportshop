package com.zph.sportshop.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.admin.dao.AdminDao;
import com.zph.sportshop.admin.service.AdminService;
import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.admin.Admin;

@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService{
	
	@Resource(name = "adminDao")
	private AdminDao adminDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.adminDao;
	}

	public Admin findByNameAndPsw(String adminName, String password) {
		// TODO Auto-generated method stub
		return adminDao.findByNameAndPsw(adminName, password);
	}

	public Admin findByName(String adminName) {
		// TODO Auto-generated method stub
		return this.adminDao.findByName(adminName);
	}
	
}
