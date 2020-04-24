package com.zph.sportshop.good.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.good.dao.GoodDao;
import com.zph.sportshop.query.PageResult;

@Repository("goodDao")
public class GoodDaoImpl extends BaseDaoImpl<Good> implements GoodDao{


	public Good findByName(String gname) {
		// TODO Auto-generated method stub
		List<Good> goods = this.hibernateTemplate.find("from Good where gname=?",gname);
		if(goods.size() != 0) return goods.get(0);
		else
		return null;
	}

	public List<Good> findByKey(String keyword) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Good where gname like ?","%"+keyword+"%");
	}

	public List<Good> findNewGoods() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.execute(new HibernateCallback<List<Good>>() {

			public List<Good> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "from Good order by gid desc";
				Query query = session.createQuery(hql);
				query.setMaxResults(8);
				List<Good> goods = query.list();
				session.close();
				return goods;
			}
		});
	}

}
