package com.zph.sportshop.chat.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.chat.dao.ChatDao;
import com.zph.sportshop.domain.chat.ChatRecord;

@Repository("chatDao")
public class ChatDaoImpl extends BaseDaoImpl<ChatRecord> implements ChatDao{

	public List<ChatRecord> findRecordByReceiveId(final Long receiveuser) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.execute(new HibernateCallback<List<ChatRecord>>() {

			public List<ChatRecord> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("from ChatRecord where receiveuser=");
				stringBuffer.append(receiveuser);
				stringBuffer.append("order by crid asc");
				Query query = session.createQuery(stringBuffer.toString());
				return query.list();
			}
		});
	}

	public List<ChatRecord> findUnreadRecordByReceiveIdAndSendId(final Long receiveuser, final Long senduser) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.execute(new HibernateCallback<List<ChatRecord>>() {

			public List<ChatRecord> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("from ChatRecord where (receiveuser=");
				stringBuffer.append(receiveuser);
				stringBuffer.append(" and senduser=");
				stringBuffer.append(senduser);
				stringBuffer.append(" and status=0) or (");
				stringBuffer.append("receiveuser=");
				stringBuffer.append(senduser);
				stringBuffer.append(" and senduser=");
				stringBuffer.append(receiveuser);
				stringBuffer.append(") and status=0");
				stringBuffer.append(" order by crid asc");
				Query query = session.createQuery(stringBuffer.toString());
				return query.list();
			}
		});
	}

	public List<ChatRecord> findReadRecordByUid(final Long senduser) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.execute(new HibernateCallback<List<ChatRecord>>() {

			public List<ChatRecord> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("from ChatRecord where (receiveuser=");
				stringBuffer.append(senduser);
				stringBuffer.append(" or senduser=");
				stringBuffer.append(senduser);
				stringBuffer.append(") and status=1");
				stringBuffer.append(" order by crid desc");
				Query query = session.createQuery(stringBuffer.toString());
				return query.list();
			}
		});
	}

	public List<ChatRecord> findUnReadRecordByUid(final Long senduser) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.execute(new HibernateCallback<List<ChatRecord>>() {

			public List<ChatRecord> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("from ChatRecord where (receiveuser=");
				stringBuffer.append(senduser);
				stringBuffer.append(" or senduser=");
				stringBuffer.append(senduser);
				stringBuffer.append(") and status=0");
				stringBuffer.append(" order by crid desc");
				Query query = session.createQuery(stringBuffer.toString());
				return query.list();
			}
		});
	}

	public List<ChatRecord> findUnReadReceiveRecordBySend(final Long senduser) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.execute(new HibernateCallback<List<ChatRecord>>() {

			public List<ChatRecord> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("from ChatRecord where");
				stringBuffer.append(" senduser=");
				stringBuffer.append(senduser);
				stringBuffer.append(" and status=0");
				stringBuffer.append(" order by crid desc");
				Query query = session.createQuery(stringBuffer.toString());
				return query.list();
			}
		});
	}

	public Integer getUnreadNum(Long receiveuser) {
		// TODO Auto-generated method stub
		List<ChatRecord> chatRecords = this.hibernateTemplate.find("from ChatRecord where status=0 and receiveuser=?",receiveuser);
		return chatRecords.size();
	}
}
