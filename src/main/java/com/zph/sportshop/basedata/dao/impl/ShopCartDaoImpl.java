package com.zph.sportshop.basedata.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.basedata.dao.ShopCartDao;
import com.zph.sportshop.domain.basedata.ShopCart;

@Repository("shopCartDao")
public class ShopCartDaoImpl extends BaseDaoImpl<ShopCart> implements ShopCartDao{
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	public List<ShopCart> getShopCartsByUid(Long uid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from ShopCart where uid=?",uid);
	}
	public void deleteByUid(Long uid) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.deleteAll(getShopCartsByUid(uid));
	}

}
