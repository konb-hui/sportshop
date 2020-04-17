package com.zph.sportshop.good.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.good.Color;

public interface ColorService extends BaseService<Color>{
	public List<Color> findColorByGid(Long gid);
	public Color findByConame(String coname);
}
