package com.zph.sportshop.good.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.good.Brand;

public interface BrandDao extends BaseDao<Brand>{
	public Brand findByName(String bname);
	public List<Brand> findAll();
}
