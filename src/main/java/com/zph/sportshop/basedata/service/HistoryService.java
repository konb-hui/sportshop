package com.zph.sportshop.basedata.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.basedata.History;

public interface HistoryService extends BaseService<History>{
	public List<History> findByOid(Long oid);
}
