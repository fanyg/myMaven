package com.pactera.service;

import org.springframework.stereotype.Service;

import com.pactera.domain.UserInfo;
@Service
public interface IUserService {

    public UserInfo getUserById(long id);
    public int insertUser(UserInfo userInfo);
    public int deleteByPrimaryKey(long l);
    public UserInfo selectByCustomerId(String l);
    public int updateByCustomerId(UserInfo record);
    
}
