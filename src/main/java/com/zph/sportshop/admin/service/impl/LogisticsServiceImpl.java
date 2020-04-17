package com.zph.sportshop.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.admin.dao.LogisticsDao;
import com.zph.sportshop.admin.service.LogisticsService;
import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.admin.Logistics;

@Service("logisticsService")
public class LogisticsServiceImpl extends BaseServiceImpl<Logistics> implements LogisticsService{
	
	@Resource(name="logisticsDao")
	private LogisticsDao logisticsDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.logisticsDao;
	}

	public Logistics findByName(String lname) {
		// TODO Auto-generated method stub
		return this.logisticsDao.findByName(lname);
	}

	public List<Logistics> findAll() {
		// TODO Auto-generated method stub
		return this.logisticsDao.findAll();
	}

}
