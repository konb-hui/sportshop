package com.zph.sportshop.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.zph.sportshop.base.dao.impl.BaseDaoImpl;
import com.zph.sportshop.basedata.dao.AddressDao;
import com.zph.sportshop.domain.basedata.Address;

@Repository("addressDao")
public class AddressDaoImpl extends BaseDaoImpl<Address> implements AddressDao{

}
