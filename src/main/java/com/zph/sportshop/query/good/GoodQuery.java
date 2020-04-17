package com.zph.sportshop.query.good;

import java.util.Map;


import com.zph.sportshop.query.BaseQuery;

public class GoodQuery extends BaseQuery{
	
	private Integer cid;




	public Integer getCid() {
		return cid;
	}




	public void setCid(Integer cid) {
		this.cid = cid;
	}




	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		if(this.cid != null) {
			this.getKeyValues().put("cid", this.cid);
		}
		return this.getKeyValues();
	}

}
