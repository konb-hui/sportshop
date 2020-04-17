package com.zph.sportshop.good.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.query.PageResult;

public interface GoodDao extends BaseDao<Good>{
	public Good findByName(String gname);
	public List<Good> findByKey(String keyword);
	public List<Good> findNewGoods();
}
