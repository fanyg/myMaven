package com.pactera.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.dao.IUserInfoDao;
import com.pactera.domain.UserInfo;
import com.pactera.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserInfoDao userDao;
      
    @Override
    public UserInfo getUserById(long id) {
        return userDao.selectByPrimaryKey(id);
    }

	@Override
	public int insertUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userDao.insert(userInfo);
	}

	@Override
	public int deleteByPrimaryKey(long l) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo selectByCustomerId(String l) {
		// TODO Auto-generated method stub
		return userDao.selectByCustomerId(l);
	}

	@Override
	public int updateByCustomerId(UserInfo record) {
		// TODO Auto-generated method stub
		return userDao.updateByCustomerId(record);
	}





}
