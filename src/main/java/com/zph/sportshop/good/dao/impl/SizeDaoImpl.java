package com.zph.sportshop.good.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.domain.good.Size;
import com.zph.sportshop.good.dao.SizeDao;

@Repository("sizeDao")
public class SizeDaoImpl extends BaseDaoImpl<Size> implements SizeDao{

	public List<Size> findSizeByGid(Long gid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Size where gid=?",gid);
	}

	public Size findBySname(String sname) {
		// TODO Auto-generated method stub
		List<Size> sizes = this.hibernateTemplate.find("from Size where sname=?",sname);
		if(sizes.size() != 0) return sizes.get(0);
		else
		return null;
	}

	public Size getByGidAndName(Long gid, String sname) {
		// TODO Auto-generated method stub
		Size size = (Size) this.hibernateTemplate.find("from Size where gid=? and sname=?",gid,sname).get(0);
		return size;
	}

}
