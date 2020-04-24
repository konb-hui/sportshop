package com.zph.sportshop.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseQuery {
	
	//当前页码，初始值为1
	private int currentPage = 1;
	
	//一页显示的条数
	private int pageSize = 2;
	
	//模糊查询关键词
	private String key;
	
	//模糊查询的列
	private ArrayList<String> searchColum = new ArrayList<String>();
			
	public ArrayList<String> getSearchColum() {
		return searchColum;
	}
	public void setSearchColum(ArrayList<String> searchColum) {
		this.searchColum = searchColum;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//把页面上的表单元素封装成map
	public Map<String, Object> keyValues = new HashMap<String, Object>();
	//把页面上的查询条件封装成一个Map<String, Object>，并且返回
	public abstract Map<String, Object> buildWhere();
	public Map<String, Object> getKeyValues() {
		return keyValues;
	}
	public void setKeyValues(Map<String, Object> keyValues) {
		this.keyValues = keyValues;
	}
	
}
