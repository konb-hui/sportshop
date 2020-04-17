package com.zph.sportshop.domain.privilege.annotation;

import java.lang.reflect.Method;

public class AnnotationParse {
	/**
	 *提供一个目标类，提供一个目标方法，获取目标方法上的name属性的值 
	 */
	public static String parse(Class targetClass,String methodName) throws Exception{
		String accessMethod = "";
		Method method = targetClass.getMethod(methodName);
		/**
		 *目标方法上存在该注解 
		 */
		if(method.isAnnotationPresent(PrivilegeInfo.class)) {
			PrivilegeInfo privilegeInfo = method.getAnnotation(PrivilegeInfo.class);
			accessMethod = privilegeInfo.name();
		}
		return accessMethod;
	}
}
