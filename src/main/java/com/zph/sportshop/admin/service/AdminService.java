package com.zph.sportshop.admin.service;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.admin.Admin;

public interface AdminService extends BaseService<Admin>{
	public Admin findByNameAndPsw(String adminName,String password);
	public Admin findByName(String adminName);
}
