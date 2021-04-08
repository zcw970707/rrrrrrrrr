package com.vote.mapper;

import com.vote.pojo.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
    Users Check(Users uu);
    int addUser(Users uu);
}
