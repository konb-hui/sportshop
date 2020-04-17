package com.zph.sportshop.good.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.good.Discount;

public interface DiscountService extends BaseService<Discount>{
	public List<Discount> listDiscountByGid(Long gid);
	public Discount findByFullAndReduce(Double fullprice,Double reduceprice);
}
