package com.zph.sportshop.good.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.good.dao.GoodDao;
import com.zph.sportshop.good.service.GoodService;

@Service("goodService")
public class GoodServiceImpl extends BaseServiceImpl<Good> implements GoodService{

	@Resource(name="goodDao")
	private GoodDao goodDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.goodDao;
	}

}
