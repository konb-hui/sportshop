package com.zph.sportshop.good.service.impl;

import java.util.List;

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

	public Good findByName(String gname) {
		// TODO Auto-generated method stub
		return this.goodDao.findByName(gname);
	}

	public List<Good> findByKey(String keyword) {
		// TODO Auto-generated method stub
		return this.goodDao.findByKey(keyword);
	}

	public List<Good> findNewGoods() {
		// TODO Auto-generated method stub
		return this.goodDao.findNewGoods();
	}

}
