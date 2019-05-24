package com.greenplatform.service;

import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.model.ywModel.TUserAccount;

import java.util.List;

public interface SystemService {
    /*系统用户操作begin
    public ReturnModel selectSystemuser(SystemUser systemUser);//查询系统用户

    public ReturnModel insertSystemUser (SystemUser systemUser);//插入系统用户信息

    public ReturnModel delSystemuser(SystemUser systemUser);//删除系统用户信息

    public ReturnModel updSystemuser(SystemUser systemUser);//修改系统用户*/

    /*种子商店操作begin*/
    public ReturnModel selectTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//查询商品明细

    public ReturnModel insertTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//插入商品明细

    public ReturnModel delTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//删除商品明细

    public ReturnModel updTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//修改商品明细

    //能量汇总表操作
    public ReturnModel selectTGreenNlHz (TGreenNlHz tGreenNlHz);//查询能量汇总表

    public ReturnModel insertTGreenNlHz (TGreenNlHz tGreenNlHz);//插入能量汇总表

    public ReturnModel delTGreenNlHz (TGreenNlHz tGreenNlHz);//删除能量汇总表

    public ReturnModel updTGreenNlHz (TGreenNlHz tGreenNlHz);//修改能量汇总表

    //能量增加表操作
    public ReturnModel selectTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//查询能量增加明细

    public ReturnModel insertTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//插入能量增加明细

    public ReturnModel delTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//删除能量增加明细

    public ReturnModel updTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//修改能量增加明细

    //任务明细
    public ReturnModel selectTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//查询任务明细

    public ReturnModel insertTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//插入任务明细

    public ReturnModel delTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//删除任务明细

    public ReturnModel updTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//修改任务明细

    //增加种子
    public ReturnModel selectTGreenZzZjzzmx (TGreenZzZjzzmx tGreenZzZjzzmx);//查询增加种子明细

    public ReturnModel insertTGreenZzZjzzmx (TGreenZzZjzzmx tGreenZzZjzzmx);//插入增加种子明细

    public ReturnModel delTGreenZzZjzzmx (TGreenZzZjzzmx tGreenZzZjzzmx);//删除增加种子明细

    public ReturnModel updTGreenZzZjzzmx (TGreenZzZjzzmx tGreenZzZjzzmx);//修改增加种子明细

    //查询我的账户信息（人员姓名，人员等级，能量总量，种子汇总，今日任务）
    public ReturnModel selectLoginuserAccount();

}
