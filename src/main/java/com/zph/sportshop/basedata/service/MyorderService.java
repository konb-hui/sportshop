package com.zph.sportshop.basedata.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.basedata.Myorder;
import com.zph.sportshop.query.BaseQuery;
import com.zph.sportshop.query.PageResult;

public interface MyorderService extends BaseService<Myorder>{
	public List<Myorder> listOrderByUid(Long uid);
}
