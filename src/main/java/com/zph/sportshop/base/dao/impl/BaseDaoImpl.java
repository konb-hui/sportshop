package com.zph.sportshop.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.query.BaseQuery;
import com.zph.sportshop.query.PageResult;

public class BaseDaoImpl<T> implements BaseDao<T>{
	private final Class classt;
	private ClassMetadata classMetadata;//元数据，描述持久化类的对象
	/*
	 * 把泛型的参数提取出来的过程放入到构造函数中去
	 * 因为当子类创建对象的时候，直接调用父类的构造函数
	 * */
	public BaseDaoImpl() {
		/*
		 * this代表子类
		 * this.getClass().getGenericSuperclass()就是父类：BaseDaoImpl<T>泛型
		 * */
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		//得到T的实际类型
		this.classt = (Class) type.getActualTypeArguments()[0];
	}
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	@PostConstruct
	public void init() {//初始化方法
		this.classMetadata = this.hibernateTemplate.getSessionFactory().getClassMetadata(this.classt);
	}
	
	public PageResult<T> findPageResult(final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<PageResult<T>>() {

			public PageResult<T> doInHibernate(Session session) throws HibernateException, SQLException {
				int totalSize = getCount(baseQuery);
				PageResult<T> pageResult = new PageResult<T>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), totalSize);
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("from " + classt.getSimpleName());
				stringBuffer.append(" where 1=1 ");
				//在map中封装的查询条件
				Map<String, Object> keyValues = baseQuery.buildWhere();
				for(Entry<String, Object> entry : keyValues.entrySet()) {
					/**
					 * 在一对多的情况下，例如Xsyddzhib
					 *    entry.getKey()="xsyddzhub.xsyddzhubid"
					 *    "where xsyddzhub.xsyddzhubid=:xsyddzhubid"
					 */
					if(entry.getKey().contains(".")){
						stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey().split("\\.")[1]);
					}else{
						stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey());
					}
				}
				//根据拼凑的hql语句产生一个Query对象
				Query query = session.createQuery(stringBuffer.toString());
				//给hql语句的参数赋值
				for(Entry<String, Object> entry : keyValues.entrySet()) {
					if(entry.getKey().contains(".")){
						/**
						 * "where xsyddzhub.xsyddzhubid=:xsyddzhubid"的=:后面的赋值
						 */
						query.setParameter(entry.getKey().split("\\.")[1], entry.getValue());
					}else{
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				//设置当前页的第一行在集合中的位置
				int firstResult = (baseQuery.getCurrentPage() - 1) * baseQuery.getPageSize();
				//设置每页显示最多的行数
				int maxResults = baseQuery.getPageSize();
				//用hibernate的方式设置分页
				query.setFirstResult(firstResult).setMaxResults(maxResults);
				//返回枫叶的结果集
				List<T> rows = query.list();
				//把结果是指到pageResult里
				pageResult.setRows(rows);
				return pageResult;
			}
			
		});
	}

	public Collection<T> findEntry() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from " + this.classt.getSimpleName());
	}

	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(t);
	}

	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(t);
	}

	public void deleteEntriesByIds(Serializable[] ids) {
		// [1,2,3]-->1,2,3
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0; i <ids.length;i++) {
			if(i == ids.length - 1) {
				stringBuffer.append(ids[i]);
			}else {
				stringBuffer.append(ids[i] + ",");
			}
		}
		StringBuffer hql = new StringBuffer();
		hql.append("from " + this.classt.getSimpleName());
		hql.append(" where " + this.classMetadata.getIdentifierPropertyName());
		hql.append(" in(");
		hql.append(stringBuffer.toString());
		hql.append(")");
		List<T> list = this.hibernateTemplate.find(hql.toString());
		this.hibernateTemplate.deleteAll(list);
	}

	public void deleteEntry(Serializable id) {
		// TODO Auto-generated method stub
		T t = (T) this.hibernateTemplate.get(this.classt, id);
		this.hibernateTemplate.delete(t);
	}

	public T getEntry(Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.hibernateTemplate.get(this.classt, id);
	}

	public Set<T> getEntriesByIds(Serializable[] ids) {
		// TODO Auto-generated method stub
		// [1,2,3]-->1,2,3
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0; i <ids.length;i++) {
			if(i == ids.length - 1) {
				stringBuffer.append(ids[i]);
			}else {
				stringBuffer.append(ids[i] + ",");
			}
		}
		StringBuffer hql = new StringBuffer();
		hql.append("from " + this.classt.getSimpleName());
		hql.append(" where " + this.classMetadata.getIdentifierPropertyName());
		hql.append(" in(");
		hql.append(stringBuffer.toString());
		hql.append(")");
		List<T> list = this.hibernateTemplate.find(hql.toString());
		return new HashSet<T>(list);//从list到set的转化
	}

	public int getCount(final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("select count("+classMetadata.getIdentifierPropertyName()+") from " + classt.getSimpleName());
				stringBuffer.append(" where 1=1 ");
				//获取所有的查询条件
				Map<String, Object> keyValues = baseQuery.buildWhere();
				//拼接where条件的过程
				for(Entry<String, Object> entry : keyValues.entrySet()) {
					/**
					 * 在一对多的情况下，例如Xsyddzhib
					 *    entry.getKey()="xsyddzhub.xsyddzhubid"
					 *    "where xsyddzhub.xsyddzhubid=:xsyddzhubid"
					 */
					if(entry.getKey().contains(".")){
						stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey().split("\\.")[1]);
					}else{
						stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey());
					}
				}
				System.out.println(stringBuffer.toString());
				Query query = session.createQuery(stringBuffer.toString());
				//把where条件中的参数传递值的过程
				for(Entry<String, Object> entry : keyValues.entrySet()) {
					if(entry.getKey().contains(".")){
						/**
						 * "where xsyddzhub.xsyddzhubid=:xsyddzhubid"的=:后面的赋值
						 */
						query.setParameter(entry.getKey().split("\\.")[1], entry.getValue());
					}else{
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				Long count = (Long) query.uniqueResult();
				return count.intValue();
			}
			
		});
	}

	public int getCountByKey(final BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("select count("+classMetadata.getIdentifierPropertyName()+") from " + classt.getSimpleName());
				stringBuffer.append(" where ");
				//遍历模糊查询的列
				if(baseQuery.getSearchColum().size() != 0) {
					for (int i = 0; i < baseQuery.getSearchColum().size(); i++) {
						if(i == 0) {
							stringBuffer.append(baseQuery.getSearchColum().get(i) + " like '%" + baseQuery.getKey() + "%'");
						}else {
							stringBuffer.append(" or " + baseQuery.getSearchColum().get(i) + " like '%" + baseQuery.getKey() + "%'");
						}
					}
				}else {
					stringBuffer.append("1=1");
				}
				Query query = session.createQuery(stringBuffer.toString());
				Long count = (Long)query.uniqueResult();
				return count.intValue();
			}
		});
	}

	public PageResult<T> findPageResultByKey(final BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.execute(new HibernateCallback<PageResult<T>>() {

			public PageResult<T> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				int totalSize = getCountByKey(baseQuery);
				PageResult<T> pageResult = new PageResult<T>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), totalSize);
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("from " + classt.getSimpleName());
				stringBuffer.append(" where ");
				if(baseQuery.getSearchColum().size() != 0) {
					for (int i = 0; i < baseQuery.getSearchColum().size(); i++) {
						if(i == 0) {
							stringBuffer.append(baseQuery.getSearchColum().get(i) + " like '%" + baseQuery.getKey() + "%'");
						}else {
							stringBuffer.append(" or " + baseQuery.getSearchColum().get(i) + " like '%" + baseQuery.getKey() + "%'");
						}
					}
				}else {
					stringBuffer.append("1=1");
				}
				Query query = session.createQuery(stringBuffer.toString());
				//设置当前页的第一行在集合中的位置
				int firstResult = (baseQuery.getCurrentPage() - 1) * baseQuery.getPageSize();
				//设置每页显示最多的行数
				int maxResults = baseQuery.getPageSize();
				//用hibernate的方式设置分页
				query.setFirstResult(firstResult).setMaxResults(maxResults);
				//返回分页的结果集
				List<T> rows = query.list();
				//把结果是指到pageResult里
				pageResult.setRows(rows);
				return pageResult;
			}
		});
	}
	public Integer deleteByForeignId(final Long id,final String idName) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				StringBuffer hql = new StringBuffer();
				hql.append("delete from " + classt.getSimpleName());
				hql.append(" where " + idName);
				hql.append("=" + id);
				Query query = session.createQuery(hql.toString());
				return query.executeUpdate();
			}
		});
	}

}
