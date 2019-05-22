package com.greenplatform.dao;

import com.greenplatform.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlateDao {
    /*平台用户操作begin*/
    /*public PlateUser checkLogin(PlateUser plateUser);//登陆验证

    public PlateUser selectPlateuserByEmail(PlateUser plateUser);//通过邮箱查询平台用户

    public PlateUser selectPlateuserByLoginname(PlateUser plateUser);//通过用户名查询平台用户

    public PlateUser selectPlateuserByUserid(PlateUser plateUser);//通过用户ID查询平台用户*/

    public List<PlateUser> selectPlateuser (PlateUser plateUser);//查询平台用户信息

    public int insertPlateuser (PlateUser plateUser);//插入平台用户信息

    public int delPlateuser (PlateUser plateUser);//删除平台用户信息

    public int updPlateuser (PlateUser plateUser);//修改平台用户
    /*平台用户操作end*/

    /*系统用户操作begin*//*
    public List selectSystemuser (SystemUser systemUser);//查询系统用户

    public int insertSystemUser (SystemUser systemUser);//插入系统用户信息

    public int delSystemuser (SystemUser systemUser);//删除系统用户信息

    public int updSystemuser (SystemUser systemUser);//修改系统用户*/
    /*系统用户操作end*/

    /*代码类别操作begin*/
    public List selectPlateCodeDmlb (PlateCodeDmlb plateCodeDmlb);//查询代码类别

    public int insertPlateCodeDmlb (PlateCodeDmlb plateCodeDmlb);//插入代码类别

    public int delPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb);//删除代码类别

    public int updPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb);//修改代码类别
    /*代码类别操作end*//*

    /*代码值操作begin*/
    public List selectPlateCodeDmz (PlateCodeDmz plateCodeDmz);//查询代码值

    public int insertPlateCodeDmz (PlateCodeDmz plateCodeDmz);//插入代码值

    public int delPlateCodeDmz (PlateCodeDmz plateCodeDmz);//删除代码值

    public int updPlateCodeDmz (PlateCodeDmz plateCodeDmz);//修改代码值
    /*代码值操作end*/

    /*种子商店操作begin*/
    public List selectTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//查询商品明细

    public int insertTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//插入商品明细

    public int delTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//删除商品明细

    public int updTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//修改商品明细
    /*种子商店操作end*/

    public List selectTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//查询任务完成量

    /*日志表操作begin*/
    /*public List selectPlateLog (PlateLog plateLog);//查询日志*/

    public int insertPlateLog (PlateLog plateLog);//插入日志
    /*日志表操作end*/


}
