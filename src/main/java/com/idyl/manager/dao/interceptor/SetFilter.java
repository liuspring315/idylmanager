package com.idyl.manager.dao.interceptor;


import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class SetFilter implements CallbackFilter {

	//拦截过滤方法，对所有set开头的方法进行拦截
	@Override
	public int accept(Method method) {
		// TODO Auto-generated method stub
		return method.getName().startsWith("set")?1:0;
	}

}