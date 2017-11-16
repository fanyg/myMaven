package com.pactera.dao;

import com.pactera.domain.UserInfo;

public interface IUserInfoDao {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(long id);

    UserInfo selectByCustomerId(String id);
    
    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    int updateByCustomerId(UserInfo record);
}