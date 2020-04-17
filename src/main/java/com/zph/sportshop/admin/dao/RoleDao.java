package com.zph.sportshop.admin.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.privilege.Role;

public interface RoleDao extends BaseDao<Role>{
	public List<Role> findAll();
	public Role findByName(String rname);
}
