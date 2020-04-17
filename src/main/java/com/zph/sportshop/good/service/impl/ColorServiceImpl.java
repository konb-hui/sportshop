package com.zph.sportshop.good.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.domain.good.Color;
import com.zph.sportshop.good.dao.ColorDao;
import com.zph.sportshop.good.service.ColorService;

@Service("colorService")
public class ColorServiceImpl extends BaseServiceImpl<Color> implements ColorService{
	
	@Resource(name="colorDao")
	private ColorDao colorDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.colorDao;
	}

	public List<Color> findColorByGid(Long gid) {
		// TODO Auto-generated method stub
		return this.colorDao.findColorByGid(gid);
	}

	public Color findByConame(String coname) {
		// TODO Auto-generated method stub
		return this.colorDao.findByConame(coname);
	}

}
