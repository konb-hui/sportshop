package com.zph.sportshop.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.admin.dao.PrivilegeDao;
import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.privilege.Privilege;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{

	public List<Privilege> findAll() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Privilege");
	}

	public Privilege findPrivilege(Long pid) {
		// TODO Auto-generated method stub
		List<Privilege> privileges = this.hibernateTemplate.find("from Privilege where pid=?",pid);
		if(privileges.size() != 0) return privileges.get(0);
		else
		return null;
	}

}
