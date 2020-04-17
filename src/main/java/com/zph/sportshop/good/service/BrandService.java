package com.zph.sportshop.good.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.good.Brand;

public interface BrandService extends BaseService<Brand>{
	public Brand findByName(String bname);
	public List<Brand> findAll();
}
