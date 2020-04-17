package com.zph.sportshop.good.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.good.Discount;
import com.zph.sportshop.good.dao.DiscountDao;

@Repository("discountDao")
public class DiscountDaoImpl extends BaseDaoImpl<Discount> implements DiscountDao{

	public List<Discount> listDiscountByGid(Long gid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Discount where gid=?",gid);
	}

	public Discount findByFullAndReduce(Double fullprice, Double reduceprice) {
		// TODO Auto-generated method stub
		List<Discount> discounts = this.hibernateTemplate.find("from Discount where fullprice=? and reduceprice=?",fullprice,reduceprice);
		if(discounts.size() != 0) return discounts.get(0);
		else
		return null;
	}

}
