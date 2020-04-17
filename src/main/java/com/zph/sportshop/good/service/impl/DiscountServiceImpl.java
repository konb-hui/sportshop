package com.zph.sportshop.good.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.good.Discount;
import com.zph.sportshop.good.dao.DiscountDao;
import com.zph.sportshop.good.service.DiscountService;

@Service("discountService")
public class DiscountServiceImpl extends BaseServiceImpl<Discount> implements DiscountService{
	
	@Resource(name="discountDao")
	private DiscountDao discountDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.discountDao;
	}

	public List<Discount> listDiscountByGid(Long gid) {
		// TODO Auto-generated method stub
		return this.discountDao.listDiscountByGid(gid);
	}

	public Discount findByFullAndReduce(Double fullprice, Double reduceprice) {
		// TODO Auto-generated method stub
		return this.discountDao.findByFullAndReduce(fullprice, reduceprice);
	}

}
