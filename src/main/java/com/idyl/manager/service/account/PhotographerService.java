package com.idyl.manager.service.account;

import com.idyl.manager.dao.account.PhotographerDao;
import com.idyl.manager.data.PhotographerExtra;
import com.idyl.manager.util.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by spring on 15-3-25.
 */
@Service
@Transactional(readOnly = true)
public class PhotographerService {

	@Autowired
	private PhotographerDao photographerDao;

	public Pager findList(Pager pager){
		return photographerDao.findList(pager);
	}

	@Transactional(readOnly = false)
	public int upRegisterCheckState(int userType,int personId,int state){
		return photographerDao.upRegisterCheckState(userType,personId,state);
	}
}
