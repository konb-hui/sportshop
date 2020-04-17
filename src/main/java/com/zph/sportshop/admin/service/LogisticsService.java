package com.zph.sportshop.admin.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.admin.Logistics;

public interface LogisticsService extends BaseService<Logistics>{
	public Logistics findByName(String lname);
	public List<Logistics> findAll();
}
