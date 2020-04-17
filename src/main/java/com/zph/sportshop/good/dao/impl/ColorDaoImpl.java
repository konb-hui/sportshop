package com.zph.sportshop.good.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.good.Color;
import com.zph.sportshop.good.dao.ColorDao;

@Repository("colorDao")
public class ColorDaoImpl extends BaseDaoImpl<Color> implements ColorDao{

	public List<Color> findColorByGid(Long gid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Color where gid=?",gid);
	}

	public Color findByConame(String coname) {
		// TODO Auto-generated method stub
		List<Color> colors = this.hibernateTemplate.find("from Color where coname=?",coname);
		if(colors.size() != 0) return colors.get(0);
		else
		return null;
	}

}
