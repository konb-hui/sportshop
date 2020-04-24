package com.zph.sportshop.query.good;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zph.sportshop.query.BaseQuery;

public class BrandQuery extends BaseQuery{
	
	public BrandQuery() {
		// TODO Auto-generated constructor stub
		this.getSearchColum().add("bname");
	}

	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		return this.getKeyValues();
	}

}
