package com.zph.sportshop.admin.dao;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.admin.Admin;

public interface AdminDao extends BaseDao<Admin>{
	public Admin findByNameAndPsw(String adminName,String password);
	public Admin findByName(String adminName);
}
