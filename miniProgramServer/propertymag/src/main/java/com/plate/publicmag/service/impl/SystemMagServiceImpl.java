package com.plate.publicmag.service.impl;

import com.plate.publicmag.dao.PublicMenuMapper;
import com.plate.publicmag.dao.PublicMenuTypeMapper;
import com.plate.publicmag.dao.owerDao.SystemMagMapper;
import com.plate.publicmag.model.PublicMenuType;
import com.plate.publicmag.model.PublicMenuTypeExample;
import com.plate.publicmag.model.PublicUser;
import com.plate.publicmag.model.baseModel.ReturnModel;
import com.plate.publicmag.service.SystemMagService;
import com.plate.publicmag.util.returnUtil.ReturnModelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class SystemMagServiceImpl implements SystemMagService {
    @Autowired
    SystemMagMapper systemMagMapper;
    @Autowired
    PublicMenuTypeMapper publicMenuTypeMapper;

    /**
     * 根据当前登录用户查询当前用户的权限
     * @param httpSession
     * @return
     */
    @Override
    public ReturnModel selectMenuByLoginUser(HttpSession httpSession) {
        PublicUser publicUser = (PublicUser) httpSession.getAttribute("loginUser");//当前登录用户
        List retList = new ArrayList();
        Map queryMap = new HashMap();//查询参数
        //先查询菜单类型
        PublicMenuTypeExample publicMenuTypeExample = new PublicMenuTypeExample();
        PublicMenuTypeExample.Criteria criteria = publicMenuTypeExample.createCriteria();
        criteria.andStatusEqualTo("1");
        publicMenuTypeExample.setOrderByClause("sort");
        List loginUserPowerTypeList = publicMenuTypeMapper.selectByExample(publicMenuTypeExample);
        //System.out.println(loginUserPowerTypeList);
        for (int i = 0;i<loginUserPowerTypeList.size();i++){
            Map menuTypeMap = new HashMap();//封装的返回结果对象
            PublicMenuType publicMenuType = (PublicMenuType) loginUserPowerTypeList.get(i);
            queryMap.put("userid",publicUser.getId());
            queryMap.put("menuType",publicMenuType.getTypeCode());
            List loginUserPowerList = systemMagMapper.selectMenuByLoginUser(queryMap);//根据菜单类型和用户id返回用户菜单

            menuTypeMap.put("menuTypeCode",publicMenuType.getTypeCode());
            menuTypeMap.put("menuTypeName",publicMenuType.getTypeNameShort());
            menuTypeMap.put("menuTypeIcon",publicMenuType.getImageUrl());
            menuTypeMap.put("menuList",loginUserPowerList);
            retList.add(menuTypeMap);
        }
        System.out.println(retList);
        return ReturnModelHandler.success(retList);
    }
}
