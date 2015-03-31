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
			"  (CASE  WHEN USER_TYPE=1 THEN '会员'  WHEN USER_TYPE=2 THEN '摄影师' WHEN USER_TYPE=3 THEN '造型师' ELSE '摄影机构管理员' END) USERTYPENAME,"+
			"  USER_NAME , EMAIL EMAIL, PASSWORD PASSWORD, FAMILY_NAME, LAST_NAME ,"+
			" MOBILE MOBILE, TELEPHONE TELEPHONE, LOCATION LOCATION, BIRTHDAY BIRTHDAY, HEAD_THUMB , "+
			"ADD_TIME , BEGIN_TIME ,ID ID,"+
			"USER_GENERAL_INFO_ID ,"+
			"INTRODUCTION,"+
			"AUTHENTICATION,"+
			"CERTIFICATE_TYPE ,"+
			"CERTIFICATE_NUM ,"+
			"IDCARD_FRONT ,"+
			"IDCARD_BACK ,"+
			"DEPOSIT,"+
			"REMARK,"+
			"REGISTER_CHECK_STATE,GENDER,(CASE WHEN GENDER = 0 THEN '男' ELSE '女' END) GENDERNAME, "+
			"(CASE WHEN REGISTER_CHECK_STATE = 1 THEN '待审核' WHEN REGISTER_CHECK_STATE = 2 THEN '审核通过' ELSE '审核不通过' END) REGISTER_CHECK_STATE_NAME"+
			" FROM user_general_info G, photographer_extra C "+
			"WHERE G.ID = C.USER_GENERAL_INFO_ID ORDER BY G.ID";
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
