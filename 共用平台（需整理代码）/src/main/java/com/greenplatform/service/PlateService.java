package com.greenplatform.service;


import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import net.sf.json.JSONObject;

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


    /*查询登陆用户业务权限*/
    public ReturnModel selectLoginuserYwqx();

    /*查询系统用户角色*/
    public ReturnModel selectPlateUserRole(PlateUserRole plateUserRole);
    /*新增系统用户角色*/
    public ReturnModel insertPlateUserRole(PlateUserRole plateUserRole);
    /*修改系统用户角色*/
    public ReturnModel updPlateUserRole(PlateUserRole plateUserRole);
    /*删除系统用户角色*/
    public ReturnModel delPlateUserRole(PlateUserRole plateUserRole);

    /*查询系统业务功能菜单*/
    public ReturnModel selectPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu);
    /*新增业务功能菜单*/
    public ReturnModel insertPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu);
    /*新增业务功能菜单*/
    public ReturnModel updPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu);
    /*新增业务功能菜单*/
    public ReturnModel delPlateYwLxMenu(PlateYwLxMenu plateYwLxMenu);

    /*查询指定角色拥有的功能权限*/
    public ReturnModel selectPermissionByRole(String cRole);

    /*查询指定角色被授予给了哪些用户*/
    public ReturnModel selectPlateuserByRole(String cRole);

    /*保存角色权限*/
    public ReturnModel saveUserRolePermission(JSONObject jsonObject);

    /*保存用户角色*/
    public ReturnModel saveUserRoleMid(JSONObject jsonObject);

    /*用户能量查询统计*/
    public ReturnModel selectTGreenNlHz(JSONObject jsonObject);

    /*查询系统参数*/
    public ReturnModel selectPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs);
    /*新增系统参数*/
    public ReturnModel insertPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs);
    /*修改系统参数*/
    public ReturnModel updPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs);
    /*删除系统参数*/
    public ReturnModel delPlateCodeXtcs(PlateCodeXtcs plateCodeXtcs);

    /*能量充值*/
    public ReturnModel insertTGreenNlCzjl(JSONObject jsonObject);
    /*能量提现*/
    public ReturnModel insertTGreenNlTxjl(JSONObject jsonObject);
    /*用户加入黑名单*/
    public ReturnModel insertPlateuserBlacklist(JSONObject jsonObject);

    /*修改密码*/
    public ReturnModel updPlateUserPass(String cPassword);

}
