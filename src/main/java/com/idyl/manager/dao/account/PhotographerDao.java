package com.idyl.manager.dao.account;

import com.idyl.manager.dao.BaseDaoImpl;
import com.idyl.manager.data.PhotographerExtra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by spring on 15-3-24.
 */
@Component
public class PhotographerDao extends BaseDaoImpl<PhotographerExtra> {

	final String LIST_SQL = "SELECT USER_TYPE ,"+
			"  (case USER_TYPE when 1 then '会员'  when 2 then '摄影师' when 3 then '造型师' else '摄影机构管理员' end) USER_TYPE_NAME,"+
			"  USER_NAME , EMAIL email, PASSWORD password, FAMILY_NAME, LAST_NAME ,"+
			" MOBILE mobile, TELEPHONE telephone, LOCATION location, BIRTHDAY birthday, HEAD_THUMB , "+
			"ADD_TIME , BEGIN_TIME ,ID id,"+
			"user_general_info_id ,"+
			"introduction,"+
			"authentication,"+
			"certificate_type ,"+
			"certificate_num ,"+
			"idcard_front ,"+
			"idcard_back ,"+
			"deposit,"+
			"remark,"+
			"register_check_state "+
			" FROM user_general_info g, photographer_extra c "+
			"WHERE g.id = c.user_general_info_id order by g.id";
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}


	public List<PhotographerExtra> findList(int page,int pagesize)
	{
		return super.getPage(LIST_SQL,page,pagesize);
	}

}
