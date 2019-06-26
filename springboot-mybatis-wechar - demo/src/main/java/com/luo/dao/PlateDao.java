package com.luo.dao;

import com.luo.model.PlateUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlateDao {
    public PlateUser checkLogin(PlateUser plateUser);//登陆验证

    public PlateUser selectUserByEmail(PlateUser plateUser);//验证注册用户邮箱

    public PlateUser selectUserByLoginname(PlateUser plateUser);//验证注册用户会员名

    public PlateUser insertUser(PlateUser plateUser);//注册用户
}
