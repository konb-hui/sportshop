package com.zph.sportshop.good.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.good.Comment;
import com.zph.sportshop.good.dao.CommentDao;
import com.zph.sportshop.good.service.CommentService;

@Service("commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService{
	
	@Resource(name="commentDao")
	private CommentDao commentDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.commentDao;
	}

}
