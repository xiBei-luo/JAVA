package com.plate.publicmag.service.impl;

import com.plate.publicmag.dao.PublicUserMapper;
import com.plate.publicmag.model.PublicUserExample;
import com.plate.publicmag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    PublicUserMapper publicUserMapper;


    @Override
    public List selectAllUser() {
        PublicUserExample publicUserExample = new PublicUserExample();
        publicUserExample.setOrderByClause("id");
        List userList = publicUserMapper.selectByExample(publicUserExample);
        return userList;
    }
}
