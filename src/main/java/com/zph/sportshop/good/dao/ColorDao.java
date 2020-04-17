package com.zph.sportshop.good.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.good.Color;

public interface ColorDao extends BaseDao<Color>{
	public List<Color> findColorByGid(Long gid);
	public Color findByConame(String coname);
}
