package com.muxin.app.service;

import com.muxin.app.dao.entry.Users;


public interface UserService {

    Boolean LoginInfo(Users users);

    Boolean registered(Users users);
}
