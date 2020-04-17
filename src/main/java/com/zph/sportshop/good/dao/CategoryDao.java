package com.zph.sportshop.good.dao;


import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.good.Category;

public interface CategoryDao extends BaseDao<Category>{
	public Category findByName(String cname);
	public List<Category> findAll();
}
