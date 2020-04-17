package com.zph.sportshop.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zph.sportshop.query.BaseQuery;

public class UserQuery extends BaseQuery{
	
	private String sex;
	private String username;
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(this.sex)) {
			this.keyValues.put("sex", sex);
		}
		if(StringUtils.isNotBlank(this.username)) {
			this.keyValues.put("username", username);
		}
		return this.getKeyValues();
	}

}
