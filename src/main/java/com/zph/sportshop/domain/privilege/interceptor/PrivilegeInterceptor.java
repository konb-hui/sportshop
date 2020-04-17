package com.zph.sportshop.domain.privilege.interceptor;

import java.util.Collection;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zph.sportshop.domain.privilege.Privilege;
import com.zph.sportshop.domain.privilege.annotation.AnnotationParse;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {

		Collection<Privilege> functions = (Collection<Privilege>) ServletActionContext
				.getRequest().getSession().getAttribute("functions");
		/**
		 *获取访问目标的注解的name属性的值 
		 */
		Class targetClass = invocation.getAction().getClass();
		String methodName = invocation.getProxy().getMethod();
		String accessMethod = AnnotationParse.parse(targetClass, methodName);
		/**
		 *判断用户是否具有该功能权限 
		 */
		if("".equals(accessMethod)) {//如果目标放大上没有权限的注解或者谢了注解没有那么属性直接放行
			return invocation.invoke();
		}else {
			if(functions == null) {
				ActionContext.getContext().getValueStack().push("您还没有登录");
				return "privilege_error";
			}
			boolean flag = false;
			for(Privilege privilege:functions) {
				if(privilege.getFunctionName().equals(accessMethod)) {
					flag = true;
					break;
				}
			}
			if(flag) {
				return invocation.invoke();
			}else {
				ActionContext.getContext().getValueStack().push("您没有权限访问");
				return "privilege_error";
			}
		}
	}

}
