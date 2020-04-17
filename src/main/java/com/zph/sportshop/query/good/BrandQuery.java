package com.zph.sportshop.query.good;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zph.sportshop.query.BaseQuery;

public class BrandQuery extends BaseQuery{
	
	private String bname;
	
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(this.bname)) {
			this.getKeyValues().put("bname", this.bname);
		}
		return this.getKeyValues();
	}

}
