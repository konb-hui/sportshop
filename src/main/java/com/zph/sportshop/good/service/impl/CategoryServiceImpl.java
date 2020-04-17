package com.zph.sportshop.good.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.good.Category;
import com.zph.sportshop.good.dao.CategoryDao;
import com.zph.sportshop.good.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService{
	
	@Resource(name="categoryDao")
	private CategoryDao categoryDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.categoryDao;
	}

	public Category findByName(String cname) {
		// TODO Auto-generated method stub
		return this.categoryDao.findByName(cname);
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return this.categoryDao.findAll();
	}


}
