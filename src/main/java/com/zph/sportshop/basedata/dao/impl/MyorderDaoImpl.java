package com.zph.sportshop.basedata.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.basedata.dao.MyorderDao;
import com.zph.sportshop.domain.basedata.Myorder;
import com.zph.sportshop.query.BaseQuery;
import com.zph.sportshop.query.PageResult;

@Repository("myorderDao")
public class MyorderDaoImpl extends BaseDaoImpl<Myorder> implements MyorderDao{
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public List<Myorder> listOrderByUid(Long uid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Myorder where uid=?",uid);
	}

}
