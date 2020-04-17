package com.zph.sportshop.good.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.good.Size;
import com.zph.sportshop.good.dao.SizeDao;
import com.zph.sportshop.good.service.SizeService;

@Service("sizeService")
public class SIzeServiceImpl extends BaseServiceImpl<Size> implements SizeService{
	
	@Resource(name="sizeDao")
	private SizeDao sizeDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.sizeDao;
	}

	public List<Size> findSizeByGid(Long gid) {
		// TODO Auto-generated method stub
		return this.sizeDao.findSizeByGid(gid);
	}

	public Size findBySname(String sname) {
		// TODO Auto-generated method stub
		return this.sizeDao.findBySname(sname);
	}

}
