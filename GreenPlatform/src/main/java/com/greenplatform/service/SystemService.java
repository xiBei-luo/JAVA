package com.greenplatform.service;

import com.greenplatform.model.SystemUser;
import com.greenplatform.model.TGreenSpSpmx;
import com.greenplatform.model.base.ReturnModel;

public interface SystemService {
    /*系统用户操作begin*/
    public ReturnModel selectSystemuser(SystemUser systemUser);//查询系统用户

    public ReturnModel insertSystemUser (SystemUser systemUser);//插入系统用户信息

    public ReturnModel delSystemuser(SystemUser systemUser);//删除系统用户信息

    public ReturnModel updSystemuser(SystemUser systemUser);//修改系统用户
    /*系统用户操作end*/

    /*种子商店操作begin*/
    public ReturnModel selectTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//查询商品明细

    public ReturnModel insertTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//插入商品明细

    public ReturnModel delTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//删除商品明细

    public ReturnModel updTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//修改商品明细
    /*种子商店操作end*/
}
