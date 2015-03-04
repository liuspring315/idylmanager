package com.idyl.manager.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created on 12-9-11
 * <p>描述: 基于spring jdbc的BaseDAO</p>
 * <p>版权所有： 首都信息发展有限责任公司</p>
 *
 * @version 0.1
 * @liuzhaochun
 */
public interface BaseSpringJdbcDao{
	
    /**
     * <p>描述:更新数据库 用于不带参数的静态sql更新语句</p>
     * @param sql
     * @author: liuzhaochun
     * @update:
     */
    public void update(String sql);

    /**
     * <p>描述:更新数据库</p>
     * @param sql
     * @param params 参数值
     * @param types  参数类型 如Types.VARCHAR
     * @author: liuzhaochun
     * @update:
     */
    public void update(String sql, Object[] params, int[] types);

    /**
     * <p>描述:删除指定的记录</p>
     * @param sql
     * @param params
     * @param types
     * @author: liuzhaochun
     * @update:
     */
    public void delete(String sql, Object[] params, int[] types);

    /**
     * <p>描述:返回一行一列，数字</p>
     * @param sql
     * @return
     * @author: liuzhaochun
     * @update:
     */
    public int queryForInt(String sql);

    public String queryForString(String sql);
    
    /**
     * <p>描述:返回一行一列，数字</p>
     * @param sql
     * @param args
     * @param argTypes
     * @return
     * @author: liuzhaochun
     * @update:
     */
    public int queryForInt(String sql, Object[] args, int[] argTypes);

    /**
     * <p>描述:返回一行,返回Map<String,Object></p>
     * @param sql
     * @param args
     * @param argTypes
     * @return
     * @author: liuzhaochun
     * @update:
     */
    public Map<String,Object> queryForMap(String sql, Object[] args, int[] argTypes);

    /**
     * <p>描述:查询多条数据，不做自定义对象封装，返回List<Map<String,Object>></p>
     * @param sql
     * @param args
     * @param argTypes
     * @return
     * @author: liuzhaochun
     * @update:
     */
    public List<Map<String,Object>> query(String sql, Object[] args, int[] argTypes);

    public Date getSysDate();

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
    public List findDatas(final int first, final int size, final String sql);

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
    public List findPageDatas(final int first, final int size, final String sql, final Object[] values);

}