package com.zph.sportshop.admin.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.admin.Logistics;

public interface LogisticsDao extends BaseDao<Logistics>{
	public Logistics findByName(String lname);
	public List<Logistics> findAll();
}
