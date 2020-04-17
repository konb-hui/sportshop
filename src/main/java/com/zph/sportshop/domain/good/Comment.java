package com.zph.sportshop.domain.good;

import java.io.Serializable;
import java.sql.Date;

import com.zph.sportshop.domain.basedata.User;

public class Comment implements Serializable{
	private Long commentId;
	private String content;
	private Date ctime;
	private Integer rank;
	private User user;
	private Good good;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
}
