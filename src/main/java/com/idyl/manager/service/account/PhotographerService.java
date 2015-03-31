package com.idyl.manager.service.account;

import com.idyl.manager.dao.account.PhotographerDao;
import com.idyl.manager.data.PhotographerExtra;
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

	public List<PhotographerExtra> findList(int page,int pagesize){
		return photographerDao.findList(page,pagesize);
	}
}
