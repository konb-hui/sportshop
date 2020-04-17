package com.zph.sportshop.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.admin.dao.PrivilegeDao;
import com.zph.sportshop.admin.service.PrivilegeService;
import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.privilege.Privilege;

@Service("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService{
	
	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Privilege> findAll() {
		// TODO Auto-generated method stub
		return this.privilegeDao.findAll();
	}

	public Privilege findPrivilege(Long pid) {
		// TODO Auto-generated method stub
		return this.privilegeDao.findPrivilege(pid);
	}

}
