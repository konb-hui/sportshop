package com.zph.sportshop.good.dao.impl;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.good.Comment;
import com.zph.sportshop.good.dao.CommentDao;

@Repository("commentDao")
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao{

}
