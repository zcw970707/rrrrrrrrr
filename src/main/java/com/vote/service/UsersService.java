package com.vote.service;

import com.vote.pojo.Users;
import org.apache.catalina.User;

public interface UsersService {
    Users Check(Users uu);
    int addUser(Users uu);
}
