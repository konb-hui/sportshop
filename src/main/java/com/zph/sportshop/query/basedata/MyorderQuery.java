package com.zph.sportshop.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zph.sportshop.query.BaseQuery;

public class MyorderQuery extends BaseQuery{
	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(this.status)) {
			this.getKeyValues().put("status", this.status);
		}
		return this.getKeyValues();
	}

}
