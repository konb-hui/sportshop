package com.zph.sportshop.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zph.sportshop.query.BaseQuery;

public class UserQuery extends BaseQuery{
	
	public UserQuery() {
		// TODO Auto-generated constructor stub
		this.getSearchColum().add("username");
		this.getSearchColum().add("account");
	}
	
	private String sex;
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(this.sex)) {
			this.keyValues.put("sex", sex);
		}
		return this.getKeyValues();
	}

}
