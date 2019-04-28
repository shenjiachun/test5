package com.xiaoya.scaffold.provider.mapper;

import com.xiaoya.scaffold.provider.bean.DemoUser;

import java.util.List;

/**
* Created by Mybatis Generator on 2019-04-24 下午07:59:05
*/
public interface DemoUserMapper {
    List<DemoUser> selectAllUsers();

    int deleteByPrimaryKey(Integer userId);

    int insert(DemoUser record);

    int insertSelective(DemoUser record);

    DemoUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(DemoUser record);

    int updateByPrimaryKey(DemoUser record);
}