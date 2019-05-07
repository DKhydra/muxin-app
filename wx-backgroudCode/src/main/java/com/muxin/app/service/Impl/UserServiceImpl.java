package com.muxin.app.service.Impl;

import com.muxin.app.dao.entry.Users;
import com.muxin.app.dao.mapper.UsersMapper;
import com.muxin.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public Boolean LoginInfo(Users users) {
        Users result = usersMapper.selectByUserInfo(users);
        return result!= null ? true:false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean registered(Users users) {
        //测试阶段 必要字段用户帐号，密码，二维码，cid
        Integer result =usersMapper.insert(users);
        return result== 1 ? true : false;
    }
}
