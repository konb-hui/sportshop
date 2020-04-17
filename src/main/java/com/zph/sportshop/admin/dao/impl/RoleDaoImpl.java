package com.zph.sportshop.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.admin.dao.RoleDao;
import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.privilege.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Role");
	}

	public Role findByName(String rname) {
		// TODO Auto-generated method stub
		List<Role> roles = this.hibernateTemplate.find("from Role where rname=?",rname);
		if(roles.size() != 0) return roles.get(0);
		else
		return null;
	}

}
