package com.zph.sportshop.basedata.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.basedata.ShopCart;

public interface ShopCartDao extends BaseDao<ShopCart>{
	public List<ShopCart> getShopCartsByUid(Long uid);
	public void deleteByUid(Long uid);
}
