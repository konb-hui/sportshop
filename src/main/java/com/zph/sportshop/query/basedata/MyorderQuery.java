package com.zph.sportshop.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zph.sportshop.query.BaseQuery;

public class MyorderQuery extends BaseQuery{
	
	private String status;
	
	private Long oid;
	
	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

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
		}if(this.oid != null) {
			this.getKeyValues().put("oid", this.oid);
		}
		return this.getKeyValues();
	}

}
