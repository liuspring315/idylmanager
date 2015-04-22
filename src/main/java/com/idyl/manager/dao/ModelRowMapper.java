package com.idyl.manager.dao;

import com.idyl.manager.dao.interceptor.UpdateFactory;
import org.springframework.jdbc.core.RowMapper;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * 使用包cglib和asm来创建对某一对象setters方法的拦截器
 *
 * @author Administrator
 *
 */
public class ModelRowMapper<T> implements RowMapper {

	/**
	 * @param args
	 */
	Class<?> clazz;

	public ModelRowMapper(Class<?> clazz) {
		this.clazz = clazz;
	}

	// RowMapper中直接通过field给字段设值，避免干扰set拦截器的使用
	public static Object setValues(HashMap<String, Object> map, Object entity) {
		try {
			Field[] fields = entity.getClass().getSuperclass().getDeclaredFields();;
			for (Field field : fields) {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
						entity.getClass());
				Method getMethod = pd.getReadMethod();//获得get方法
				Annotation[] annotations  = getMethod.getAnnotations();//获得get方法注解
				for (Annotation an : annotations) {
					if (an instanceof Column) {
						Column column = (Column) an;
						Object value = map.get(column.name().toUpperCase());
						Method wm = pd.getWriteMethod();
						wm.invoke(entity,value);
						break;
					}
				}
			}
			fields = entity.getClass().getDeclaredFields();
			for (Field field : fields) {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
						entity.getClass());
				Method getMethod = pd.getReadMethod();//获得get方法
				Annotation[] annotations  = getMethod.getAnnotations();//获得get方法注解
				for (Annotation an : annotations) {
					if (an instanceof Column) {
						Column column = (Column) an;
						Object value = map.get(column.name().toUpperCase());
						Method wm = pd.getWriteMethod();
						wm.invoke(entity,value);
						break;
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return entity;
	}

	public void setValues(ResultSet rs, Object entity) {

		try {
			Field[] fields = clazz.getSuperclass().getDeclaredFields();
			for (Field field : fields) {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
						entity.getClass());
				Method getMethod = pd.getReadMethod();//获得get方法
				Annotation[] annotations  = getMethod.getAnnotations();//获得get方法注解
				for (Annotation an : annotations) {
					if (an instanceof Column) {
						Column column = (Column) an;
						Object value = rs.getObject(column.name().toUpperCase());
						Method wm = pd.getWriteMethod();
//						System.out.println(entity+":"+value);
						wm.invoke(entity, value);

						break;
					}
				}
			}
			fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
						entity.getClass());
				Method getMethod = pd.getReadMethod();//获得get方法
				Annotation[] annotations  = getMethod.getAnnotations();//获得get方法注解
				for (Annotation an : annotations) {
					if (an instanceof Column) {
						Column column = (Column) an;
						Object value = rs.getObject(column.name().toUpperCase());
						Method wm = pd.getWriteMethod();
						wm.invoke(entity,value);
						break;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		//通过更新工厂的静态方法创建类实例，使它被CGLIB监控
		T entity = (T) UpdateFactory.createVO(clazz);
		setValues(rs, entity);
		return entity;
	}

}