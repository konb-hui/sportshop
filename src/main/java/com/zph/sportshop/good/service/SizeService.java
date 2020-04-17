package com.zph.sportshop.good.service;

import java.util.List;

import com.zph.sportshop.base.service.BaseService;
import com.zph.sportshop.domain.good.Size;

public interface SizeService extends BaseService<Size>{
	public List<Size> findSizeByGid(Long gid);
	public Size findBySname(String sname);
}
