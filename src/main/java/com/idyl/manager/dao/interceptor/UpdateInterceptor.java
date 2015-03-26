package com.idyl.manager.dao.interceptor;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UpdateInterceptor implements MethodInterceptor {

	/**
	 * 拦截方法的实现，拦截对象object的属性变化并记录
	 */
	@Override
	public Object intercept(Object object, Method method, Object[] args,
	                        MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		String methodName = method.getName();
		String attribute=methodName.substring(3).toLowerCase();
		int hash=object.hashCode();
		System.out.println(object.hashCode()+" intercep");
		UpdateFactory.addChange(hash, attribute, args[0]);
		return methodProxy.invokeSuper(object, args);
	}

}