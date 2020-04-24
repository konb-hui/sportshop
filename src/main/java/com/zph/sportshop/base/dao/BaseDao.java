package com.zph.sportshop.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.zph.sportshop.query.BaseQuery;
import com.zph.sportshop.query.PageResult;

public interface BaseDao<T> {
	//分页的查询
	public PageResult<T> findPageResult(final BaseQuery baseQuery);
	
	//不分页的查询
	public Collection<T> findEntry();
	
	//保存
	public void saveEntry(T t);
	
	//更新
	public void updateEntry(T t);
	
	//根据ids删除一些数据
	public void deleteEntriesByIds(Serializable[] ids);
	
	//根据id删除一条数据
	public void deleteEntry(Serializable id);
	
	//根据id提取一条数据
	public T getEntry(Serializable id);
	
	//根据ids提取一些数据
	public Set<T> getEntriesByIds(Serializable[] ids);
	
	//查询某一张表的记录数
	public int getCount(final BaseQuery baseQuery);
	
	//模糊查询某张表的记录数
	public int getCountByKey(final BaseQuery baseQuery);
	
	//模糊查询某张表的记录
	public PageResult<T> findPageResultByKey(final BaseQuery baseQuery);
}
