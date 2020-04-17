package com.zph.sportshop.basedata.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.basedata.ShopCart;

public interface ShopCartService extends BaseService<ShopCart>{
	public List<ShopCart> getShopCartsByUid(Long uid);
	public void deleteByUid(Long uid);
}
