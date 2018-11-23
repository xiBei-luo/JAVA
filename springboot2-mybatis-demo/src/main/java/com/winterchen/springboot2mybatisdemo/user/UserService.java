package com.winterchen.springboot2mybatisdemo.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.springboot2mybatisdemo.model.UserDomain;

/**
 * Created by Luowenlv on 2018/9/10,9:59
 */
public interface UserService {
    int addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);
}
