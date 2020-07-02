package com.zph.sportshop.chat.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.chat.ChatRecord;

public interface ChatService extends BaseService<ChatRecord>{
	public List<ChatRecord> findRecordByReceiveId(Long receiveuser);
	public List<ChatRecord> findUnreadRecordByReceiveIdAndSendId(Long receiveuser,Long senduser);
	public List<ChatRecord> findReadRecordByUid(Long senduser);
	public List<ChatRecord> findUnReadRecordByUid(Long senduser);
	public List<ChatRecord> findUnReadReceiveRecordBySend(Long senduser);
	public Integer getUnreadNum(Long receiveuser);
}
