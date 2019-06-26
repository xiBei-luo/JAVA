package com.greenplatform.service.impl;

import com.greenplatform.dao.*;
import com.greenplatform.model.*;
import com.greenplatform.model.baseModel.ReturnModel;
import com.greenplatform.service.Loginservice;
import net.sf.ehcache.search.expression.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginServiceImpl implements Loginservice {
    @Autowired
    PlateUserMapper plateUserMapper;
    @Autowired
    PlateUserPermissionMapper plateUserPermissionMapper;
    @Autowired
    PlateUserRoleMapper plateUserRoleMapper;
    @Autowired
    PlateYwLxMapper plateYwLxMapper;
    @Autowired
    PlateYwLxMenuMapper plateYwLxMenuMapper;

    @Override
    public ReturnModel checkLogin(PlateUser plateUser) {
        ReturnModel returnModel = new ReturnModel();

        Map userInfo = new HashMap();
        //1.查询用户(主键)
        PlateUser plateUser1 = plateUserMapper.selectByPrimaryKey(plateUser.getcUserid());
        userInfo.put("plateUser",plateUser1);

        //2.查询用户角色(cUserid)
        PlateUserRoleExample plateUserRoleExample = new PlateUserRoleExample();
        plateUserRoleExample.createCriteria().andCUseridEqualTo(plateUser1.getcUserid());
        List plateUserRoleList = plateUserRoleMapper.selectByExample(plateUserRoleExample);
        userInfo.put("plateUserRole",plateUserRoleList);

        //3.查询角色拥有的功能
        Iterator iterator1 = plateUserRoleList.iterator();
        while (iterator1.hasNext()){
            PlateUserRole plateUserRole1 = (PlateUserRole) iterator1.next();

            PlateUserPermissionExample plateUserPermissionExample = new PlateUserPermissionExample();
            plateUserPermissionExample.createCriteria().andNRoleEqualTo(plateUserRole1.getnRole());
            List plateUserPermissionList = plateUserPermissionMapper.selectByExample(plateUserPermissionExample);
            //userInfo.put("plateUserPermission",plateUserPermissionList);

            List plateYwLxList = new ArrayList();
            Iterator iterator2 = plateUserPermissionList.iterator();
            while (iterator2.hasNext()){
                PlateUserPermission plateUserPermission1 = (PlateUserPermission) iterator2.next();
                PlateYwLxMenu plateYwLxMenu = plateYwLxMenuMapper.selectByPrimaryKey(plateUserPermission1.getcMenudm());
                plateYwLxList.add(plateYwLxMenu);
            }
            userInfo.put("plateYwLxMenu",plateYwLxList);
        }
        System.out.println(userInfo);
        returnModel.setFlag(0);
        returnModel.setMsg("");
        returnModel.setData(userInfo);
        return returnModel;
    }
}
