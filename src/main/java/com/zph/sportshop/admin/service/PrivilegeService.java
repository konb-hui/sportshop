package com.zph.sportshop.admin.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.privilege.Privilege;

public interface PrivilegeService extends BaseService<Privilege>{
	public List<Privilege> findAll();
	public Privilege findPrivilege(Long pid);
}
