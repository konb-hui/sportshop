package com.zph.sportshop.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.system.Info;
import com.zph.sportshop.system.dao.InfoDao;
import com.zph.sportshop.system.service.InfoService;

@Service("infoService")
public class InfoServiceImpl extends BaseServiceImpl<Info> implements InfoService{
	
	@Resource(name="infoDao")
	private InfoDao infoDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.infoDao;
	}


}
