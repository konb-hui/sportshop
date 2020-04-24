package com.zph.sportshop.query.admin;

import java.util.Map;

import com.zph.sportshop.query.BaseQuery;

public class LogisticsQuery extends BaseQuery{
	public LogisticsQuery() {
		// TODO Auto-generated constructor stub
		this.getSearchColum().add("lname");
	}
	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		return this.getKeyValues();
	}

}
