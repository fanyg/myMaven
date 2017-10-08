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
    
    public UserServiceImpl() {
        System.out.println("UserServiceImpl");
    }
    
    public UserInfo getUserById(long id) {
        return userDao.selectByPrimaryKey(id);
    }

}
