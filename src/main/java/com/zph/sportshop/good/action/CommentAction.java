package com.zph.sportshop.good.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.sportshop.base.action.BaseAction;
import com.zph.sportshop.basedata.service.HistoryService;
import com.zph.sportshop.domain.basedata.History;
import com.zph.sportshop.domain.basedata.User;
import com.zph.sportshop.domain.good.Comment;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.good.service.CommentService;
import com.zph.sportshop.good.service.GoodService;

@Controller("commentAction")
@Scope("prototype")
public class CommentAction extends BaseAction<Comment>{
	
	@Resource(name="commentService")
	private CommentService commentService;
	@Resource(name="goodService")
	private GoodService goodService;
	@Resource(name="historyService")
	private HistoryService historyService;
	private Long gid;
	private Long hid;
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public Long getHid() {
		return hid;
	}
	public void setHid(Long hid) {
		this.hid = hid;
	}
	public String addComment() {
		Map map = ActionContext.getContext().getSession();
		User user = (User) map.get("user");
		if(user != null) {
			Good good = this.goodService.getEntry(this.gid);
			History history = this.historyService.getEntry(this.hid);
			Comment comment = new Comment();
			comment.setRank(this.getModel().getRank());
			comment.setContent(this.getModel().getContent());
			comment.setUser(user);
			comment.setGood(good);
			history.setIscomment("是");
			this.historyService.updateEntry(history);
			this.commentService.saveEntry(comment);
		}
		return SUCCESS;
	}
}
