package com.idyl.manager.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created on 12-9-11
 * <p>描述:    [所属模块及功能描述]</p>
 * <p>版权所有： 首都信息发展有限责任公司</p>
 * @version 0.1
 * @liuzhaochun
 */
public class BaseSpringJdbcDaoImpl implements BaseSpringJdbcDao {
	
    /**
     * spring注入的JdbcTemplate
     */
    protected JdbcTemplate jdbcTemplate;

    /**
     * <p>描述:更新数据库 用于不带参数的静态sql更新语句</p>
     * @param sql
     * @author: liuzhaochun
     * @update:
     */
    @Override
    public void update(String sql) {
        jdbcTemplate.update(sql);

    }

    /**
     * 更新数据库
     * @param sql
     * @param args
     * @param argTypes
     */
    @Override
    public void update(String sql, Object[] args, int[] argTypes) {
        jdbcTemplate.update(sql, args, argTypes);
    }

    public void update(String sql, Object[] args) {
        jdbcTemplate.update(sql, args);
    }

    /**
     * <p>描述:删除指定的记录</p>
     * @param sql
     * @param args
     * @param argTypes
     * @author: liuzhaochun
     * @update:
     */
    @Override
    public void delete(String sql, Object[] args, int[] argTypes) {
        jdbcTemplate.update(sql, args, argTypes);
    }

    /**
     * <p>描述:返回一行一列，数字</p>
     * @param sql
     * @return
     * @author: liuzhaochun
     * @update:
     */
    @Override
    public int queryForInt(String sql) {
        return jdbcTemplate.queryForInt(sql);
    }

    /**
     * <p>描述:返回一行一列，数字</p>
     * @param sql
     * @param args
     * @param argTypes
     * @return
     * @author: liuzhaochun
     * @update:
     */
    @Override
    public int queryForInt(String sql, Object[] args, int[] argTypes) {
        return jdbcTemplate.queryForInt(sql, args, argTypes);
    }

    public String queryForString(String sql){
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    /**
     * <p>描述:返回一行,返回Map<String,Object></p>
     * @param sql
     * @param args
     * @param argTypes
     * @return
     * @author: liuzhaochun
     * @update:
     */
    public Map<String,Object> queryForMap(String sql,Object[] args,int[] argTypes){
        return jdbcTemplate.queryForMap(sql, args, argTypes);
    }

    /**
     * <p>描述:查询多条数据，不做自定义对象封装，返回List<Map<String,Object>></p>
     * @param sql
     * @param args
     * @param argTypes
     * @return
     * @author: liuzhaochun
     * @update:
     */
    @Override
    public List<Map<String, Object>> query(String sql, Object[] args, int[] argTypes) {
        return jdbcTemplate.queryForList(sql, args, argTypes);
    }

    public Date getSysDate(){
        return jdbcTemplate.queryForObject("select sysdate from dual",Date.class);
    }

    /**
     * <p>描述:* 根据查询数据开始位置first和返回数据个数size，返回满足SQL的数据集合，
     * 与业务层的findDatas相对应</p>
     * @param first 数据开始位置
     * @param size 需要返回的数据个数(最大数)
     * @param sql SQL语句
     * @return 返回关联对象集合
     * @return
     * @author: liuzhaochun
     * @update:
     */
    @Override
    public List findDatas(int first, int size, String sql) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * <p>描述:分页查询</p>
     * @param first
     * @param size
     * @param sql
     * @param values
     * @return
     * @author: liuzhaochun
     * @update:
     */
    @Override
    public List findPageDatas(int first, int size, String sql, Object[] values) {
        // TODO Auto-generated method stub
        return null;
    }

}