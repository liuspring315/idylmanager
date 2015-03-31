package com.idyl.manager.service.account;

import com.idyl.manager.dao.account.UserDao;
import com.idyl.manager.data.Admin;
import com.idyl.manager.util.MD5Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 *
 * 作成日期： 2012-8-16 
 * <p>功能描述:安全相关实体的管理类,包括用户和权限组</p>
 * @author  liuzhaocun
 * @version 0.1
 */
//Spring Bean的标识.
@Component("accountService")
//默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class  AccountService {
    @Autowired
    private UserDao userDao;



    public Admin findUserByLoginName(String loginName,String password) {
        return userDao.findByLoginName(loginName, MD5Builder.getMD5(password));
    }

    public static void main(String[] args){
        System.out.println(MD5Builder.getMD5("abc123"));
        //e99a18c428cb38d5f260853678922e03
    }


}
