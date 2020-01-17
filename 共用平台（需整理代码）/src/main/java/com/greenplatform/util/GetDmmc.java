package com.greenplatform.util;

import com.greenplatform.dao.PlateUserMapper;
import com.greenplatform.model.PlateUser;
import com.greenplatform.model.PlateUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GetDmmc {

    @Autowired
    private static PlateUserMapper plateUserMapper;


    //查询基础代码表中数据
    public static String getDmmc(String cDmlb,String cDm){

        return null;
    }

    //查询商品名称
    public static String getSpmc(String cspbh){

        return null;
    }

    //获取用户姓名
    public static String getUsername(String cUserid){
        if (!(("").equals(cUserid) || null == cUserid)){
            PlateUser plateUser = plateUserMapper.selectByPrimaryKey(cUserid);
            return plateUser.getcUsername();
        }else{
            return "";
        }
    }


}
