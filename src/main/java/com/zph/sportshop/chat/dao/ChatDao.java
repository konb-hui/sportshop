package com.zph.sportshop.chat.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.chat.ChatRecord;

public interface ChatDao extends BaseDao<ChatRecord>{
	public List<ChatRecord> findRecordByReceiveId(final Long receiveuser);
	public List<ChatRecord> findUnreadRecordByReceiveIdAndSendId(final Long receiveuser,final Long senduser);
	public List<ChatRecord> findReadRecordByUid(final Long senduser);
	public List<ChatRecord> findUnReadRecordByUid(final Long senduser);
	public List<ChatRecord> findUnReadReceiveRecordBySend(final Long senduser);
	public Integer getUnreadNum(Long receiveuser);
}
