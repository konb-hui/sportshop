package com.zph.sportshop.good.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.good.Category;

public interface CategoryService extends BaseService<Category>{
	public Category findByName(String cname);
	public List<Category> findAll();
}
