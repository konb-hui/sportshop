package com.zph.sportshop.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.admin.dao.RoleDao;
import com.zph.sportshop.admin.service.RoleService;
import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.privilege.Role;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	
	@Resource(name="roleDao")
	private RoleDao roleDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.roleDao;
	}

	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return this.roleDao.findAll();
	}

	public Role findByName(String rname) {
		// TODO Auto-generated method stub
		return this.roleDao.findByName(rname);
	}

}
