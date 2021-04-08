package com.vote.service.impl;

import com.vote.mapper.UsersMapper;
import com.vote.pojo.Users;
import com.vote.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper um;
    @Override
    public Users Check(Users uu) {
        return um.Check(uu);
    }

    @Override
    public int addUser(Users uu) {
        return um.addUser(uu);
    }
}
