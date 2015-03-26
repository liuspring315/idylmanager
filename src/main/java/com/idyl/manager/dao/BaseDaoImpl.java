package com.idyl.manager.dao;

/**
 * Created by spring on 15-3-23.
 */

import com.idyl.manager.dao.interceptor.UpdateFactory;
import com.mysql.jdbc.Statement;
import net.sf.cglib.proxy.Enhancer;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class BaseDaoImpl<T> {
	Logger logger=Logger.getLogger(BaseDaoImpl.class);
	//POJO类的实际类型
	Class<T> entityType;
	//简单地将POJO类名映射成数据库表名
	String table;
	public JdbcTemplate jdbcTemplate;
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		// 使用该语法后，BaseDaoImpl无法正常使用，只能通过子类调用它
		// 用于获取实际输入的Model类型
		if (t instanceof ParameterizedType) {
			entityType = (Class<T>) ((ParameterizedType) t)
					.getActualTypeArguments()[0];
		} else if (((Class<?>) t).getGenericSuperclass() instanceof ParameterizedType) {
			entityType = (Class<T>) ((ParameterizedType) ((Class<?>) t)
					.getGenericSuperclass()).getActualTypeArguments()[0];
		} else {
			entityType = (Class<T>) ((ParameterizedType) ((Class<?>) ((Class<?>) t)
					.getGenericSuperclass()).getGenericSuperclass())
					.getActualTypeArguments()[0];
		}
		this.table = ReflectUtil.getTable(entityType);
	}

	@SuppressWarnings("unchecked")
	public List<T> queryAll() {
		String sql = "select * from " + table;
		List<T> list = jdbcTemplate.query(sql, new ModelRowMapper(entityType));
		return list;
	}

	/**
	 * 根据ID，查询一条记录并用实体包装
	 *
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T load(int id) {
		String sql = "select * from " + table + " where id=" + id;
		List<T> list = jdbcTemplate.query(sql, new ModelRowMapper(entityType));
		return list.size() == 0 ? null : list.get(0);
	}

	/**
	 * 根据ID，删除指定表里的记录
	 *
	 * @param id
	 */
	public void delete(int id) {
		String sql = "delete from " + table + " where id=" + id;
		jdbcTemplate.execute(sql);
	}

	/**
	 * 根据ID更新实体数据到数据库
	 *
	 * @param entity
	 * @param id
	 */
	@SuppressWarnings("unchecked")
	public void update(T entity, int id) {
		assert Enhancer.isEnhanced(entity.getClass()) : "没有被拦截器监控到更新数据";
		StringBuilder sql = new StringBuilder();
		sql.append("update " + table + " set ");
		System.out.println(entity.hashCode());
		HashMap<String, Object> map = UpdateFactory.getChanges(entity.hashCode());
		List<String> keys = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String) entry.getKey();
			Object val = entry.getValue();
			keys.add(key);
			values.add(val);
		}
		for (int i = 0; i < keys.size(); i++) {
			if (i == keys.size() - 1) {
				sql.append(keys.get(i) + "=? ");
			} else {
				sql.append(keys.get(i) + "=?,");
			}
		}
		sql.append("where id=?");
		logger.info("更新语句："+sql.toString());
		values.add(id);
		jdbcTemplate.update(sql.toString(), setParams(values.toArray()));
	}

	/**
	 * 插入实体，并返回数据库自增生成的ID
	 *
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int insert(T entity) {
		final StringBuilder sql = new StringBuilder();

		sql.append("insert into " + table + "(");
		HashMap<String, Object> map = getChangesForInsert(entity);
		List<String> columns = new ArrayList<String>();
		final List<Object> values = new ArrayList<Object>();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String) entry.getKey();
			Object val = entry.getValue();
			columns.add(key);
			values.add(val);
		}
		for (int i = 0; i < columns.size(); i++) {
			if (i == columns.size() - 1) {
				sql.append(columns.get(i) + ") values(");
			} else {
				sql.append(columns.get(i) + ",");
			}
		}

		for (int i = 0; i < values.size(); i++) {
			if (i == values.size() - 1) {
				sql.append("?)");
			} else {
				sql.append("?,");
			}
		}
		logger.info("插入语句："+sql.toString());
		KeyHolder key = new GeneratedKeyHolder();
		final String insertSql=sql.toString();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// TODO Auto-generated method stub
				//必须设置Statement.RETURN_GENERATED_KEYS才能进行返回ID
				PreparedStatement ps = jdbcTemplate.getDataSource()
						.getConnection().prepareStatement(insertSql,Statement.RETURN_GENERATED_KEYS);
				for (int i = 0; i < values.size(); i++) {
					ps.setObject(i + 1, values.get(i));
				}
				return ps;
			}
		}, key);
		return key.getKey().intValue();
	}

	/**
	 * 插入实体并返回被插入的实体
	 *
	 * @param entity
	 * @return
	 */
	public T persist(final T entity) {
		int id=insert(entity);
		//直接通过connection进行提交同样无法成功
//      transaction.commit();
		logger.info("数据库返回的自增ID为："+id);
		T persisted=load(id);
		return persisted;
	}
	/**
	 *
	 * @param sc
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> query(SearchCriteria sc){
		String where = sc.generateWhereClause();
		StringBuilder sb = new StringBuilder("select * from "+sc.getTable());
		sb.append(where);
		logger.info("查询语句"+sb.toString());
		logger.info("查询参数"+Arrays.toString(sc.generateParams()));
		List<T> list = jdbcTemplate.query(sb.toString(), setParams(sc.generateParams()),new ModelRowMapper(entityType));
		return list;
	}
	/**
	 * 返回DAO对应的数据库表的总记录数
	 * @return
	 */
	public int getTotalCount(){
		String sql="select count(*) from "+table;
		return jdbcTemplate.queryForInt(sql);
	}
	/**
	 * 以pagesize大小的页，返回第page页的数据
	 * @param page
	 * @param pagesize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> getPage(int page,int pagesize){
		if(page<0||pagesize<0){
			throw new IllegalArgumentException("页码或页大小参数不合法");
		}
		String sql="select * from "+table+" limit "+page*pagesize+","+(page+1)*pagesize;
		return jdbcTemplate.query(sql, new ModelRowMapper<T>(entityType));
	}

	public List<T> getPage(String s,int page,int pagesize){
		if(page<0||pagesize<0){
			throw new IllegalArgumentException("页码或页大小参数不合法");
		}
		String sql="select * from "+s+" limit "+page*pagesize+","+(page+1)*pagesize;
		return jdbcTemplate.query(sql, new ModelRowMapper<T>(entityType));
	}
	/**
	 * 直接执行sql查询语句，param作为参数数组
	 * @param sql
	 * @param params
	 * 返回查询到的结果列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> executeRawSql(String sql,Object[] params){
		return jdbcTemplate.query(sql, setParams(params)
				, new ModelRowMapper<T>(entityType));
	}
	public List<T> executeRawSql(String sql,Map params){
		return namedParameterJdbcTemplate.query(sql, params
				, new ModelRowMapper<T>(entityType));
	}

	/**
	 * 设置查询用的参数列表
	 * @param params
	 * @return
	 */
	protected PreparedStatementSetter setParams(final Object[] params) {
		return new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
		};
	}
	/**
	 * 返回待插入实体上的所有非空属性值及属性名的Map
	 * @param entity
	 * @return
	 */
	protected HashMap<String, Object> getChangesForInsert(T entity){
		Field[] fields = entityType.getDeclaredFields();

		HashMap<String, Object> insertValues = new HashMap<String, Object>();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				//跳过id字段
				if("id".equalsIgnoreCase(field.getName()))
					continue;
				Object value = field.get(entity);
				if (value == null)
					continue;
				insertValues.put(field.getName(), value);

			}
			return insertValues;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
