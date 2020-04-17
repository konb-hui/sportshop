package com.zph.sportshop.basedata.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.basedata.dao.ShopCartDao;
import com.zph.sportshop.basedata.service.ShopCartService;
import com.zph.sportshop.domain.basedata.ShopCart;

@Service("shopCartService")
public class ShopCartServiceDao extends BaseServiceImpl<ShopCart> implements ShopCartService{

	@Resource(name="shopCartDao")
	private ShopCartDao shopCartDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.shopCartDao;
	}

	public List<ShopCart> getShopCartsByUid(Long uid) {
		// TODO Auto-generated method stub
		return this.shopCartDao.getShopCartsByUid(uid);
	}

	public void deleteByUid(Long uid) {
		// TODO Auto-generated method stub
		this.shopCartDao.deleteByUid(uid);
	}

}
