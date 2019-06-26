/*
package com.greenplatform.dao;

import com.greenplatform.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlateDao {
    */
/*平台用户操作begin*//*

    public List<PlateUser> selectPlateuser (PlateUser plateUser);//查询平台用户信息

    public int insertPlateuser (PlateUser plateUser);//插入平台用户信息

    public int delPlateuser (PlateUser plateUser);//删除平台用户信息

    public int updPlateuser (PlateUser plateUser);//修改平台用户

    */
/*代码类别操作begin*//*

    public List selectPlateCodeDmlb (PlateCodeDmlb plateCodeDmlb);//查询代码类别

    public int insertPlateCodeDmlb (PlateCodeDmlb plateCodeDmlb);//插入代码类别

    public int delPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb);//删除代码类别

    public int updPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb);//修改代码类别

    */
/*代码值操作begin*//*

    public List selectPlateCodeDmz (PlateCodeDmz plateCodeDmz);//查询代码值

    public int insertPlateCodeDmz (PlateCodeDmz plateCodeDmz);//插入代码值

    public int delPlateCodeDmz (PlateCodeDmz plateCodeDmz);//删除代码值

    public int updPlateCodeDmz (PlateCodeDmz plateCodeDmz);//修改代码值

    */
/*种子商店操作begin*//*

    public List selectTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//查询商品明细

    public int insertTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//插入商品明细

    public int delTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//删除商品明细

    public int updTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//修改商品明细

    */
/*任务完成量操作begin*//*

    public List selectTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//查询任务完成量

    */
/*日志表操作begin*//*

    */
/*public List selectPlateLog (PlateLog plateLog);//查询日志*//*


    public int insertPlateLog (PlateLog plateLog);//插入日志

    */
/*能量汇总表操作begin*//*

    public List selectTGreenNlHz (TGreenNlHz tGreenNlHz);//查询能量汇总

    public int insertTGreenNlHz (TGreenNlHz tGreenNlHz);//插入能量汇总

    public int delTGreenNlHz (TGreenNlHz tGreenNlHz);//删除能量汇总

    public int updTGreenNlHz (TGreenNlHz tGreenNlHz);//修改能量汇总

    */
/*能量增加明细表操作begin*//*

    public List selectTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//查询能量增加明细

    public int insertTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//插入能量增加明细

    public int delTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//删除增加明细

    public int updTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//修改增加明细


}
*/
