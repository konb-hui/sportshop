package com.zph.sportshop.basedata.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.basedata.dao.HistoryDao;
import com.zph.sportshop.basedata.service.HistoryService;
import com.zph.sportshop.domain.basedata.History;

@Service("historyService")
public class HistoryDaoImpl extends BaseServiceImpl<History> implements HistoryService{
	
	@Resource(name="historyDao")
	private HistoryDao historyDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.historyDao;
	}

	public List<History> findByOid(Long oid) {
		// TODO Auto-generated method stub
		return this.historyDao.findByOid(oid);
	}

}
