package com.zph.sportshop.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.system.Info;
import com.zph.sportshop.system.dao.InfoDao;

@Repository("infoDao")
public class InfoDaoImpl extends BaseDaoImpl<Info> implements InfoDao{

}
