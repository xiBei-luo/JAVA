package com.greenplatform.service;


import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface PlateService {
    /*public ReturnModel checkLogin(PlateUser plateUser);

    public ReturnModel selectPlateuserByEmail(PlateUser plateUser);//验证注册用户邮箱

    public ReturnModel selectPlateuserByLoginname(PlateUser plateUser);//验证注册用户会员名

    public ReturnModel insertUser(PlateUser plateUser);*/

    /*平台用户操作brgin*/
    public ReturnModel selectPlateuser(PlateUser plateUser, HttpSession session);//查询平台用户信息(登陆验证)

    public ReturnModel selectPlateuser(PlateUser plateUser);//查询平台用户信息

    public ReturnModel insertPlateuser(PlateUser plateUser, HttpSession session);//插入平台用户信息

    public ReturnModel delPlateuser(PlateUser plateUser);//删除平台用户信息

    public ReturnModel updPlateuser(PlateUser plateUser);//修改平台用户
    /*平台用户操作end*/

    /*代码类别操作begin*/
    public ReturnModel selectPlateCodeDmlb (PlateCodeDmlb plateCodeDmlb);//查询代码类别

    public ReturnModel insertPlateCodeDmlb (PlateCodeDmlb plateCodeDmlb);//插入代码类别

    public ReturnModel delPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb);//删除代码类别

    public ReturnModel updPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb);//修改代码类别
    /*代码类别操作end*/

    /*代码值操作begin*/
    public ReturnModel selectPlateCodeDmz (PlateCodeDmz plateCodeDmz);//查询代码值

    public ReturnModel insertPlateCodeDmz (PlateCodeDmz plateCodeDmz);//插入代码值

    public ReturnModel delPlateCodeDmz (PlateCodeDmz plateCodeDmz);//删除代码值

    public ReturnModel updPlateCodeDmz (PlateCodeDmz plateCodeDmz);//修改代码值
    /*代码值操作end*/

    /*日志表操作begin*/
    public ReturnModel selectPlateLog (PlateLog plateLog);//查询代码值

    public ReturnModel insertPlateLog (PlateLog plateLog);//插入代码值
    /*日志表操作end*/

    /*种子商店操作begin*/
    public ReturnModel selectTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//查询商品明细

    public ReturnModel insertTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//插入商品明细

    public ReturnModel delTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//删除商品明细

    public ReturnModel updTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//修改商品明细
    /*种子商店操作end*/

    public ReturnModel selectTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//查询任务完成量（查询指定时间已完成任务的人员）

}
