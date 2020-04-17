package com.zph.sportshop.query.good;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zph.sportshop.query.BaseQuery;

public class CategoryQuery extends BaseQuery{
	
	private String cname;
			
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(this.cname)) {
			this.getKeyValues().put("cname", this.cname);
		}
		return this.getKeyValues();
	}
}
