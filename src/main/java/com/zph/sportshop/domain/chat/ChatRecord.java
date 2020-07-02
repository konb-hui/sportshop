package com.zph.sportshop.domain.chat;

import java.io.Serializable;

public class ChatRecord implements Serializable{
	private Long crid;
	private Long senduser;
	private Long receiveuser;
	private String msgcontent;
	private String msgtime;
	private Integer status;
	public String getMsgcontent() {
		return msgcontent;
	}
	public void setMsgcontent(String msgcontent) {
		this.msgcontent = msgcontent;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsgtime() {
		return msgtime;
	}
	public void setMsgtime(String msgtime) {
		this.msgtime = msgtime;
	}
	public Long getCrid() {
		return crid;
	}
	public void setCrid(Long crid) {
		this.crid = crid;
	}
	public Long getSenduser() {
		return senduser;
	}
	public void setSenduser(Long senduser) {
		this.senduser = senduser;
	}
	public Long getReceiveuser() {
		return receiveuser;
	}
	public void setReceiveuser(Long receiveuser) {
		this.receiveuser = receiveuser;
	}
}
