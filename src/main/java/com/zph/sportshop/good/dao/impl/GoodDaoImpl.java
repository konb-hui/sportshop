package com.zph.sportshop.good.dao.impl;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.good.Good;
import com.zph.sportshop.good.dao.GoodDao;

@Repository("goodDao")
public class GoodDaoImpl extends BaseDaoImpl<Good> implements GoodDao{

}
