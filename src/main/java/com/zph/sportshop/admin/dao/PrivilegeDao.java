package com.zph.sportshop.admin.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.privilege.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege>{
	public List<Privilege> findAll();
	public Privilege findPrivilege(Long pid);
}
