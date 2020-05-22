package com.plate.publicmag.service.impl;

import com.plate.publicmag.dao.TSystemAdminMapper;
import com.plate.publicmag.model.TSystemAdmin;
import com.plate.publicmag.model.TSystemAdminExample;
import com.plate.publicmag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    TSystemAdminMapper tSystemAdminMapper;


    @Override
    public List selectAllUser() {
        TSystemAdminExample tSystemAdminExample = new TSystemAdminExample();
        tSystemAdminExample.setOrderByClause("id");
        List userList = tSystemAdminMapper.selectByExample(tSystemAdminExample);
        return userList;
    }
}
