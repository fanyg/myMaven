package com.pactera.dao;

import com.pactera.domain.UserCallService;

public interface IUserCallServiceDao {
    int deleteByPrimaryKey(Long id);

    int insert(UserCallService record);

    int insertSelective(UserCallService record);

    UserCallService selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCallService record);

    int updateByPrimaryKey(UserCallService record);
}