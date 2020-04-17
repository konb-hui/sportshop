package com.zph.sportshop.good.dao;

import java.util.List;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.domain.good.Size;

public interface SizeDao extends BaseDao<Size>{
	public List<Size> findSizeByGid(Long gid);
	public Size findBySname(String sname);
}
