package com.micro.provider.dao;

import com.micro.provider.dto.RequestParamDto;
import com.micro.provider.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User validateUser(User user);

    List<User> getUserLsit(RequestParamDto requestParamDto);
}