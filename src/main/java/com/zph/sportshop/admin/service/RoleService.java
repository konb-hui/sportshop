package com.zph.sportshop.admin.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.privilege.Role;

public interface RoleService extends BaseService<Role>{
	public List<Role> findAll();
	public Role findByName(String rname);
}
