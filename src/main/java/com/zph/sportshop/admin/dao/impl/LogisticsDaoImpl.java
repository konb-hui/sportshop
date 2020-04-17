package com.zph.sportshop.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.admin.dao.LogisticsDao;
import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.admin.Logistics;

@Repository("logisticsDao")
public class LogisticsDaoImpl extends BaseDaoImpl<Logistics> implements LogisticsDao{

	public Logistics findByName(String lname) {
		// TODO Auto-generated method stub
		List<Logistics> logistics = this.hibernateTemplate.find("from Logistics where lname=?",lname);
		if(logistics.size() != 0) return logistics.get(0);
		else
		return null;
	}

	public List<Logistics> findAll() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Logistics");
	}

}
