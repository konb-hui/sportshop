package com.zph.sportshop.util.websocket;

import java.io.IOException;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/ws/bitcoinServer")
public class ChatServer {
	
	//与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	private String id;
	@OnOpen
	public void onOpen(Session session){
		this.session = session;     
	}
	
	public void sendMessage(String message) throws IOException{
		this.session.getBasicRemote().sendText(message);
	}

	@OnClose
	public void onClose(){
		if(this.id != null) {
			ServerManager.remove(this.id);  
		}
	}

	@OnMessage
	public void onMessage(String array, Session session) {
		String[] strs = array.split(",", 3);
		this.id = strs[0];
		if(strs.length == 1) {
			if(!ServerManager.isExist(this.id)) {
				ServerManager.add(this.id, this);
			}
		}else {
			if(Integer.valueOf(strs[0]) < 0) {
				ServerManager.send(strs[1],strs[0] + "," + strs[2],0);
			}else {
				ServerManager.send(strs[1],strs[0] + "," + strs[2],1);
			}
			System.out.println("来自客户端的消息:" + strs[0] + "," + strs[1] + "," + strs[2]);
		}
	}

	@OnError
	public void onError(Session session, Throwable error){
		System.out.println("发生错误");
		error.printStackTrace();
	}

}

