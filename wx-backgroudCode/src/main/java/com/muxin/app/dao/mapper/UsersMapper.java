package com.muxin.app.dao.mapper;

import com.muxin.app.dao.entry.Users;


public interface UsersMapper {

    int deleteByPrimaryKey(String id);



    int insertSelective(Users record);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);


    Users selectByUserInfo(Users user);

    int insert(Users record);
}