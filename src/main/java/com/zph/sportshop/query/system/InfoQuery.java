package com.zph.sportshop.query.system;

import java.util.Map;

import com.zph.sportshop.query.BaseQuery;

public class InfoQuery extends BaseQuery{
	
	private Long adminId;
	
	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		if(this.adminId != null) {
			this.getKeyValues().put("adminId", this.adminId);
		}
		return this.getKeyValues();
	}

}
