package com.zph.sportshop.basedata.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.basedata.dao.MyorderDao;
import com.zph.sportshop.basedata.service.MyorderService;
import com.zph.sportshop.domain.basedata.Myorder;
import com.zph.sportshop.query.BaseQuery;
import com.zph.sportshop.query.PageResult;

@Service("myorderService")
public class MyorderServiceImpl extends BaseServiceImpl<Myorder> implements MyorderService{
	
	@Resource(name="myorderDao")
	private MyorderDao myorderDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.myorderDao;
	}

	public List<Myorder> listOrderByUid(Long uid) {
		// TODO Auto-generated method stub
		return this.myorderDao.listOrderByUid(uid);
	}


}
