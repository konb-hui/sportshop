package com.zph.sportshop.good.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.good.Category;
import com.zph.sportshop.good.dao.CategoryDao;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao{

	public Category findByName(String cname) {
		// TODO Auto-generated method stub
		List<Category> categories = this.hibernateTemplate.find("from Category where cname=?",cname);
		if(categories.size() == 0) return null;
		else return categories.get(0);
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Category");
	}

}
