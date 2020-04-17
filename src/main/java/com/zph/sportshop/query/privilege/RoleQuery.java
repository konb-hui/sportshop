package com.zph.sportshop.query.privilege;

import java.util.Map;

import com.zph.sportshop.query.BaseQuery;

public class RoleQuery extends BaseQuery{

	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		return this.getKeyValues();
	}

}
