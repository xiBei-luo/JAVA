package com.winterchen.springboot2mybatisdemo.dao;

import com.winterchen.springboot2mybatisdemo.model.UserDomain;

import java.util.List;

/**
 * Created by Luowenlv on 2018/9/10,9:52
 */
public interface UserDao {
    int insert(UserDomain record);


    List<UserDomain> selectUsers();
}
