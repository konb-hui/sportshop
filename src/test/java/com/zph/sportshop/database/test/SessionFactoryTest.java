package com.zph.sportshop.database.test;

import org.junit.Test;

import com.zph.sportshop.test.utils.SpringUtils;

public class SessionFactoryTest extends SpringUtils{
	@Test
	public void testSeessionFactory(){
		context.getBean("sessionFactory");
	}
}
