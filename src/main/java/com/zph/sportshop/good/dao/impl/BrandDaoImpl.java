package com.zph.sportshop.good.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.good.Brand;
import com.zph.sportshop.good.dao.BrandDao;

@Repository("brandDao")
public class BrandDaoImpl extends BaseDaoImpl<Brand> implements BrandDao{
	
	public Brand findByName(String bname) {
		// TODO Auto-generated method stub
		List<Brand> brands = this.hibernateTemplate.find("from Brand where bname=?",bname);
		if(brands.size() != 0) return brands.get(0);
		else return null;
	}

	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Brand");
	}
	
}
