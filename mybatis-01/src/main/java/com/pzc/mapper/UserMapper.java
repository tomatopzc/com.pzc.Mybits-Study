package com.pzc.mapper;

import com.pzc.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);

    int addUser(User user);

    int upDate(User user);

    int deleteById(int id);


}
