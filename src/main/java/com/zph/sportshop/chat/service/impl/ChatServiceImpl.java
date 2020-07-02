package com.zph.sportshop.chat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.chat.dao.ChatDao;
import com.zph.sportshop.chat.service.ChatService;
import com.zph.sportshop.domain.chat.ChatRecord;

@Service("chatService")
public class ChatServiceImpl extends BaseServiceImpl<ChatRecord> implements ChatService{
	
	@Resource(name="chatDao")
	private ChatDao chatDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.chatDao;
	}

	public List<ChatRecord> findRecordByReceiveId(Long receiveuser) {
		// TODO Auto-generated method stub
		return this.chatDao.findRecordByReceiveId(receiveuser);
	}

	public List<ChatRecord> findUnreadRecordByReceiveIdAndSendId(Long receiveuser, Long senduser) {
		// TODO Auto-generated method stub
		return this.chatDao.findUnreadRecordByReceiveIdAndSendId(receiveuser, senduser);
	}

	public List<ChatRecord> findReadRecordByUid(Long senduser) {
		// TODO Auto-generated method stub
		return this.chatDao.findReadRecordByUid(senduser);
	}

	public List<ChatRecord> findUnReadRecordByUid(Long senduser) {
		// TODO Auto-generated method stub
		return this.chatDao.findUnReadRecordByUid(senduser);
	}

	public List<ChatRecord> findUnReadReceiveRecordBySend(Long senduser) {
		// TODO Auto-generated method stub
		return this.chatDao.findUnReadReceiveRecordBySend(senduser);
	}

	public Integer getUnreadNum(Long receiveuser) {
		// TODO Auto-generated method stub
		return this.chatDao.getUnreadNum(receiveuser);
	}

}
