package com.zph.sportshop.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.sportshop.base.dao.BaseDao;
import com.zph.sportshop.base.service.impl.BaseServiceImpl;
import com.zph.sportshop.basedata.dao.AddressDao;
import com.zph.sportshop.basedata.service.AddressService;
import com.zph.sportshop.domain.basedata.Address;

@Service("addressService")
public class AddressServiceImpl extends BaseServiceImpl<Address> implements AddressService{
	
	@Resource(name="addressDao")
	private AddressDao addressDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.addressDao;
	}

}
