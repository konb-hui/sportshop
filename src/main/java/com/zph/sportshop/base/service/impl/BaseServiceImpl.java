package com.zph.sportshop.base.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.query.BaseQuery;
import com.zph.sportshop.query.PageResult;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
	
	public abstract BaseDao getbaseDao();
	
	@Transactional
	public PageResult<T> findPageResult(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return this.getbaseDao().findPageResult(baseQuery);
	}
	
	@Transactional
	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.getbaseDao().saveEntry(t);
	}
	
	@Transactional
	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.getbaseDao().updateEntry(t);
	}
	
	@Transactional
	public void deleteEntryById(Serializable id) {
		// TODO Auto-generated method stub
		this.getbaseDao().deleteEntry(id);
	}
	
	@Transactional
	public void deleteEntriesByids(Serializable[] ids) {
		// TODO Auto-generated method stub
		this.getbaseDao().deleteEntriesByIds(ids);
	}
	
	public T getEntry(Serializable id) {
		return (T) this.getbaseDao().getEntry(id);
	}
	
	public Collection<T> getEntries(){
		return this.getbaseDao().findEntry();
	}
	public Set<T> getEntriesByIds(Serializable[] ids){
		return this.getbaseDao().getEntriesByIds(ids);
	}
	public PageResult<T> findPageResultByKey(BaseQuery baseQuery){
		return this.getbaseDao().findPageResultByKey(baseQuery);
	}
}
