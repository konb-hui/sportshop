package com.zph.sportshop.good.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.good.Brand;
import com.zph.sportshop.good.dao.BrandDao;
import com.zph.sportshop.good.service.BrandService;

@Service("brandService")
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements BrandService{
	
	@Resource(name="brandDao")
	private BrandDao brandDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.brandDao;
	}

	public Brand findByName(String bname) {
		// TODO Auto-generated method stub
		return this.brandDao.findByName(bname);
	}

	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return this.brandDao.findAll();
	}

}
