package com.zph.sportshop.query.admin;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zph.sportshop.query.BaseQuery;

public class AdminQuery extends BaseQuery{
	
	public AdminQuery() {
		// TODO Auto-generated constructor stub
		this.getSearchColum().add("adminName");
		this.getSearchColum().add("trueName");
	}
	
	private String sex;
	private Long rid;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(this.sex)) {
			this.getKeyValues().put("sex", this.sex);
		}
		if(this.rid != null) {
			this.getKeyValues().put("rid", this.rid);
		}
		return this.getKeyValues();
	}

}
