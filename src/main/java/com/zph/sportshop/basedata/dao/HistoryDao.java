package com.zph.sportshop.basedata.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.basedata.History;

public interface HistoryDao extends BaseDao<History>{
	public List<History> findByOid(Long oid);
}
