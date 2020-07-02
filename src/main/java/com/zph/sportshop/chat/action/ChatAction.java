package com.zph.sportshop.chat.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.basedata.service.UserService;
import com.zph.sportshop.chat.service.ChatService;
import com.zph.sportshop.domain.admin.Admin;
import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.domain.chat.ChatRecord;

@Controller("chatAction")
@Scope("prototype")
public class ChatAction extends BaseAction<ChatRecord>{
	@Resource(name="chatService")
	private ChatService chatService;
	@Resource(name="userService")
	private UserService userService;
	private Map<String, Object> result = new HashMap<String, Object>();

	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public String chatCustomerService() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user == null) return "login";
		ActionContext.getContext().put("adminId", -2);
		return "chatCustomerService";
	}
	public String sendMessage() {
		ChatRecord chatRecord = new ChatRecord();
		chatRecord.setSenduser(this.getModel().getSenduser());
		chatRecord.setReceiveuser(this.getModel().getReceiveuser());
		chatRecord.setMsgcontent(this.getModel().getMsgcontent());
		this.chatService.saveEntry(chatRecord);
		return SUCCESS;
	}
	public String chatUser() {
		Map map = ActionContext.getContext().getSession();
		Admin admin = (Admin) map.get("admin");
		if(admin != null) {
			Long adminId = admin.getAdminId() * -1;
			ActionContext.getContext().put("adminId", adminId);
		}
		return "chatUser";
	}
	public String getData() {
		Map map = ActionContext.getContext().getSession();
		Admin admin = (Admin) map.get("admin");
		Long adminId = admin.getAdminId() * -1;
		List<ChatRecord> chatRecords = this.chatService.findRecordByReceiveId(adminId);
		this.result.put("userdata", getAllUser(chatRecords)) ;
		return SUCCESS;
	}
	public String getUnreadMsg() {
		List<ChatRecord> chatRecords = this.chatService.findUnreadRecordByReceiveIdAndSendId(this.getModel().getReceiveuser(), this.getModel().getSenduser());
		this.result.put("unread", chatRecords);
		return SUCCESS;
	}
	public String getReadMsg() {
		List<ChatRecord> chatRecords = this.chatService.findReadRecordByUid(this.getModel().getSenduser());
		this.result.put("read", chatRecords);
		return SUCCESS;
	}
	public String changeStatus() {
		List<ChatRecord> chatRecords = this.chatService.findUnReadReceiveRecordBySend(this.getModel().getSenduser());
		for (Iterator iterator = chatRecords.iterator(); iterator.hasNext();) {
			ChatRecord chatRecord = (ChatRecord) iterator.next();
			chatRecord.setStatus(1);
			this.chatService.updateEntry(chatRecord);
		}
		return SUCCESS;
	}
	public String resetChatNum() {
		Map session = ActionContext.getContext().getSession();  
	    session.put("chatnum", 0);
		return SUCCESS;
	}
	public String changeChatNum() {
		Map session = ActionContext.getContext().getSession();  
	    Integer n = (Integer) session.get("chatnum");
	    n++;
	    session.put("chatnum", n);
	    this.result.put("num", n);  
	    return SUCCESS;
	}
	//获得未读消息的数据
	public Map<Long, ArrayList<Object>> getAllUser(List<ChatRecord> chatRecords){
		Map<Long, ArrayList<Object>> user = new HashMap<Long, ArrayList<Object>>();
		for (Iterator iterator = chatRecords.iterator(); iterator.hasNext();) {
			ChatRecord chatRecord = (ChatRecord) iterator.next();
			if(user.size() == 0) {
				ArrayList<Object> temp = new ArrayList<Object>();
				temp.add(chatRecord.getSenduser());
				temp.add(this.userService.getEntry(chatRecord.getSenduser()).getUsername());
				if(chatRecord.getStatus() == 0) {
					temp.add(1);
				}else {
					temp.add(0);
				}
				user.put(chatRecord.getSenduser(), temp);
			}else {
				if(user.containsKey(chatRecord.getSenduser()) && chatRecord.getStatus() == 0) {
					Integer a = (Integer) user.get(chatRecord.getSenduser()).get(2);
					a++;
					user.get(chatRecord.getSenduser()).set(2, a);
				}else {
					ArrayList<Object> temp = new ArrayList<Object>();
					temp.add(chatRecord.getSenduser());
					temp.add(this.userService.getEntry(chatRecord.getSenduser()).getUsername());
					if(chatRecord.getStatus() == 0) {
						temp.add(1);
					}else {
						temp.add(0);
					}
					user.put(chatRecord.getSenduser(), temp);
				}
			}
		}
		return user;
	}
}