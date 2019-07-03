package com.greenplatform.service;


import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;

import java.util.Map;

public interface PlateService {

    /*平台用户操作brgin*/

    public ReturnModel selectPlateuser(PlateUser plateUser);//查询平台用户信息

    public ReturnModel selectWebUser(PlateUser plateUser);//查询前端用户信息

    public ReturnModel insertPlateuser(PlateUser plateUser);//插入平台用户信息

    public ReturnModel delPlateuser(PlateUser plateUser);//删除平台用户信息

    public ReturnModel retsetPass(PlateUser plateUser);//修改平台用户（重置密码）

    public ReturnModel updPlateuser(PlateUser plateUser);//修改平台用户


    /*代码值操作begin*/
    public ReturnModel selectPlateCodeDmz (Map params);//查询代码值

    public ReturnModel selectPlateCodeDmz (PlateCodeDmz plateCodeDmz);//查询代码值

    public ReturnModel delPlateCodeDmz (PlateCodeDmz plateCodeDmz);//删除代码值

    public ReturnModel updYwjcdm (PlateCodeDmlb plateCodeDmlb,PlateCodeDmz plateCodeDmz);//修改代码值

    public ReturnModel insertYwjcdm (PlateCodeDmlb plateCodeDmlb,PlateCodeDmz plateCodeDmz);//插入代码值

    /*种子商店操作begin*/
    public ReturnModel selectTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//查询商品明细

    public ReturnModel insertTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//插入商品明细

    public ReturnModel delTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//删除商品明细

    public ReturnModel updTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//修改商品明细

    // /*任务完成量操作begin*/
    public ReturnModel selectTGreenRwRwmx (Map paramsMap);//查询任务完成量（查询指定时间已完成任务的人员）

    /*日志表操作begin*/
    public ReturnModel insertPlateLog (PlateLog plateLog);//插入代码值

}
