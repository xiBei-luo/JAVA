package com.greenplatform.service;


import com.greenplatform.model.PlateUser;
import com.greenplatform.model.base.ReturnModel;

public interface PlateService {
    public ReturnModel checkLogin(PlateUser plateUser);

    public ReturnModel selectUserByEmail(PlateUser plateUser);//验证注册用户邮箱

    public ReturnModel selectUserByLoginname(PlateUser plateUser);//验证注册用户会员名

    public ReturnModel insertUser(PlateUser plateUser);

}
