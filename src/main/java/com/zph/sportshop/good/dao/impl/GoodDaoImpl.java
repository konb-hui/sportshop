package com.zph.sportshop.good.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.good.dao.GoodDao;
import com.zph.sportshop.query.PageResult;

@Repository("goodDao")
public class GoodDaoImpl extends BaseDaoImpl<Good> implements GoodDao{


	public Good findByName(String gname) {
		// TODO Auto-generated method stub
		List<Good> goods = this.hibernateTemplate.find("from Good where gname=?",gname);
		if(goods.size() != 0) return goods.get(0);
		else
		return null;
	}

	public List<Good> findByKey(String keyword) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Good where gname like ?","%"+keyword+"%");
	}

	public List<Good> findNewGoods() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Good order by gid desc limit '5'");
	}

}
