package com.greenplatform.service;


import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;

public interface PlateService {

    /*平台用户操作brgin*/

    public ReturnModel selectPlateuser(PlateUser plateUser);//查询平台用户信息

    public ReturnModel insertPlateuser(PlateUser plateUser);//插入平台用户信息

    public ReturnModel delPlateuser(PlateUser plateUser);//删除平台用户信息

    public ReturnModel retsetPass(PlateUser plateUser);//修改平台用户（重置密码）

    public ReturnModel updPlateuser(PlateUser plateUser);//修改平台用户

    /*代码类别操作begin*/
    public ReturnModel selectPlateCodeDmlb (PlateCodeDmlb plateCodeDmlb);//查询代码类别

    public ReturnModel insertPlateCodeDmlb (PlateCodeDmlb plateCodeDmlb);//插入代码类别

    public ReturnModel delPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb);//删除代码类别

    public ReturnModel updPlateCodeDmlb(PlateCodeDmlb plateCodeDmlb);//修改代码类别

    /*代码值操作begin*/
    public ReturnModel selectPlateCodeDmz (PlateCodeDmz plateCodeDmz);//查询代码值

    public ReturnModel insertPlateCodeDmz (PlateCodeDmz plateCodeDmz);//插入代码值

    public ReturnModel delPlateCodeDmz (PlateCodeDmz plateCodeDmz);//删除代码值

    public ReturnModel updPlateCodeDmz (PlateCodeDmz plateCodeDmz);//修改代码值

    public ReturnModel insertYwjcdm (PlateCodeDmz plateCodeDmz);//插入代码值

    /*种子商店操作begin*/
    public ReturnModel selectTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//查询商品明细

    public ReturnModel insertTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//插入商品明细

    public ReturnModel delTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//删除商品明细

    public ReturnModel updTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//修改商品明细

    /*任务完成量操作begin*/
    public ReturnModel selectTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//查询任务完成量（查询指定时间已完成任务的人员）

    /*日志表操作begin*/
    public ReturnModel insertPlateLog (PlateLog plateLog);//插入代码值

    /*能量汇总表操作begin*/
    public ReturnModel selectTGreenNlHz (TGreenNlHz tGreenNlHz);//查询能量汇总表

    public ReturnModel insertTGreenNlHz (TGreenNlHz tGreenNlHz);//插入能量汇总表

    public ReturnModel delTGreenNlHz (TGreenNlHz tGreenNlHz);//删除能量汇总表

    public ReturnModel updTGreenNlHz (TGreenNlHz tGreenNlHz);//修改能量汇总表

}
