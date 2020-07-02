package com.zph.sportshop.util.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zph.sportshop.chat.service.ChatService;
import com.zph.sportshop.domain.chat.ChatRecord;

public class ServerManager {

	private static Map<String,ChatServer> servers = Collections.synchronizedMap(new HashMap<String,ChatServer>());
	
	
	public static int getTotal(){
		return servers.size();
	}
	public static void add(String id,ChatServer server){
		System.out.println("有新连接加入！ 当前总连接数是："+ servers.size());
		servers.put(id,server);
	}
	public static void remove(String id){
		System.out.println("有连接退出！ 当前总连接数是："+ servers.size());
		servers.remove(id);
	}
	public static boolean isExist(String id) {
		System.out.println(servers);
		return servers.containsKey(id);
	}
	public static void send(String id,String msg,Integer i) {
		Date date = new Date();
		String time = date.toLocaleString().replaceAll("-", "/");
		ChatRecord chatRecord = new ChatRecord();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/zph/sportshop/spring/applicationContext.xml");
		ChatService chatService = (ChatService) ctx.getBean("chatService");
		if(isExist(id)) {
			try {
				if(i == 0) {
					servers.get(id).sendMessage(msg.split(",",2)[1]);
					chatRecord.setReceiveuser(Long.valueOf(id));
					String[] strs = msg.split(",",2);
					chatRecord.setSenduser(Long.valueOf(strs[0]));
					chatRecord.setMsgcontent(strs[1]);
					chatRecord.setStatus(0);
					chatRecord.setMsgtime(time);
					chatService.saveEntry(chatRecord);
				}else {
					servers.get(id).sendMessage(msg);
					chatRecord.setReceiveuser(Long.valueOf(id));
					String[] strs = msg.split(",",3);
					chatRecord.setSenduser(Long.valueOf(strs[0]));
					chatRecord.setMsgcontent(strs[2]);
					chatRecord.setStatus(0);
					chatRecord.setMsgtime(time);
					chatService.saveEntry(chatRecord);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			if(i == 0) {
				System.out.println(3);
				chatRecord.setReceiveuser(Long.valueOf(id));
				String[] strs = msg.split(",",2);
				chatRecord.setSenduser(Long.valueOf(strs[0]));
				chatRecord.setMsgcontent(strs[1]);
				chatRecord.setStatus(0);
				chatRecord.setMsgtime(time);
				chatService.saveEntry(chatRecord);
			}else {
				chatRecord.setReceiveuser(Long.valueOf(id));
				String[] strs = msg.split(",",3);
				chatRecord.setSenduser(Long.valueOf(strs[0]));
				chatRecord.setMsgcontent(strs[2]);
				chatRecord.setStatus(0);
				chatRecord.setMsgtime(time);
				chatService.saveEntry(chatRecord);
			}
		}
	}
}
