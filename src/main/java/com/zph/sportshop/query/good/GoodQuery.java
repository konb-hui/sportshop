package com.zph.sportshop.query.good;

import java.util.Map;


import com.zph.sportshop.query.BaseQuery;

public class GoodQuery extends BaseQuery{
	
	public GoodQuery() {
		// TODO Auto-generated constructor stub
		this.getSearchColum().add("gname");
		this.getSearchColum().add("gid");
	}
	
	private Long cid;
	private Long bid;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		if(this.cid != null) {
			this.getKeyValues().put("cid", this.cid);
		}
		if(this.bid != null) {
			this.getKeyValues().put("bid", this.bid);
		}
		return this.getKeyValues();
	}

}
