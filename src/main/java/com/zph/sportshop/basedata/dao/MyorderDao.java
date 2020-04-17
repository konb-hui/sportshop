package com.zph.sportshop.basedata.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.basedata.Myorder;

public interface MyorderDao extends BaseDao<Myorder>{
	public List<Myorder> listOrderByUid(Long uid);
}
