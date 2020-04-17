package com.zph.sportshop.good.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.good.Discount;

public interface DiscountDao extends BaseDao<Discount>{
	public List<Discount> listDiscountByGid(Long gid);
	public Discount findByFullAndReduce(Double fullprice,Double reduceprice);
}
