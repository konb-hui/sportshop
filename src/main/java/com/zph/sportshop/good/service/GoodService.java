package com.zph.sportshop.good.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.good.Good;

public interface GoodService extends BaseService<Good>{
	public Good findByName(String gname);
	public List<Good> findByKey(String keyword);
	public List<Good> findNewGoods();
}
