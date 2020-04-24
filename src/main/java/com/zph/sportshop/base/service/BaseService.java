package com.zph.sportshop.base.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.zph.sportshop.query.BaseQuery;
import com.zph.sportshop.query.PageResult;

public interface BaseService<T> {
	
	public PageResult<T> findPageResult(final BaseQuery baseQuery);
	
	public void saveEntry(T t);
	
	public void updateEntry(T t);
	
	public void deleteEntryById(Serializable id);
	
	public void deleteEntriesByids(Serializable[] ids);
	
	public T getEntry(Serializable id);
	
	public Collection<T> getEntries();
	
	public Set<T> getEntriesByIds(Serializable[] ids);
	
	public PageResult<T> findPageResultByKey(final BaseQuery baseQuery);
}
