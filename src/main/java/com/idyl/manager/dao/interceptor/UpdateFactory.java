package com.idyl.manager.dao.interceptor;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.util.HashMap;

/**
 * 使用UpdateFactory存放对象被改变的属性及其值
 * 以对象的hashCode为key，值为被改变的HashMap
 * @author Administrator
 *
 */
public class UpdateFactory {


	public static HashMap<Integer,HashMap<String,Object>> changes;
	private static Enhancer enhancer;
	//以字典的方式记录每个对象的改变属性值
	static{
		changes=new HashMap<Integer, HashMap<String,Object>>();
	}

	/**
	 * 根据对象的hashCode存储对象被改变的属性值
	 * @param hash
	 * @param key
	 * @param value
	 */
	public static void addChange(Integer hash,String key,Object value){
		HashMap<String, Object> orginal=changes.get(hash);
		if(orginal==null){
			orginal=new HashMap<String, Object>();
			orginal.put(key, value);
		}else{
			orginal.put(key, value);
		}

		changes.put(hash, orginal);
	}

	/**
	 * 以对象的hashCode取出对象的所有变更
	 * @param hash
	 * @return
	 */
	public static HashMap<String, Object> getChanges(Integer hash){
		return changes.get(hash);
	}


	// 通过工厂生成对象，并产生拦截器，拦截set方法生成被改变的值Map
	/**
	 * 根据对象class生成对应实例，并使它的修改能够被CGLIB拦截
	 */
	public static Object createVO(Class<?> clazz) {
		enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		Callback[] callbacks;
		callbacks = new Callback[] { NoOp.INSTANCE, new UpdateInterceptor() };
		enhancer.setCallbacks(callbacks);
		enhancer.setCallbackFilter(new SetFilter());
		return enhancer.create();
	}
}