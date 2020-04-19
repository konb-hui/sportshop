package com.zph.sportshop.basedata.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.basedata.dao.HistoryDao;
import com.zph.sportshop.domain.basedata.History;

@Repository("historyDao")
public class HistoryDaoImpl extends BaseDaoImpl<History> implements HistoryDao{

	public List<History> findByOid(Long oid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from History where oid=?",oid);
	}
	
}
