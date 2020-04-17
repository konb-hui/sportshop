package com.zph.sportshop.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.basedata.dao.HistoryDao;
import com.zph.sportshop.domain.basedata.History;

@Repository("historyDao")
public class HistoryDaoImpl extends BaseDaoImpl<History> implements HistoryDao{

}
