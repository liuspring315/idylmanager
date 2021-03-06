
/**
 * Created on 2012-8-16 下午4:51:04 
 * <p>描述:    [所属模块及功能描述]</p>
 * <p>版权所有： 有限责任公司</p>
 * @author liuzhaochun
 * @version 0.1
 */

package com.idyl.manager.dao.account;

import com.idyl.manager.dao.BaseDaoImpl;
import com.idyl.manager.dao.BaseSpringJdbcDaoImpl;
import com.idyl.manager.data.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;


/**
 * 作成日期： 2012-8-16 
 * <p>功能描述:  用户对象的Dao interface.</p>
 * @author  liuzhaocun
 * @version 0.1
 */
@Component
public class UserDao extends BaseDaoImpl<Admin> {
    public static String ID = "ID";
    public static String EMAIL = "EMAIL";
    public static String LOGIN_NAME = "ID";
    public static String NAME = "NAME";
    public static String PASSWORD = "PASSWORD";
    private static String USER_BY_LOGINNAME = "select id,user_name,nick_name,password,user_stat,remark,begin_date from admin where user_name = ? and password = ?";


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Admin findByLoginName(String loginName,String password){
        List<Admin> list = executeRawSql(USER_BY_LOGINNAME, new Object[]{loginName,password});
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }


}
