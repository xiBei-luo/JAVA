package com.greenplatform.dao;

import com.greenplatform.model.SystemUser;
import com.greenplatform.model.TGreenSpSpmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SystemDao {
    //系统用户操作begin
    public List selectSystemuser (SystemUser systemUser);//查询系统用户

    public int insertSystemUser (SystemUser systemUser);//插入系统用户信息

    public int delSystemuser (SystemUser systemUser);//删除系统用户信息

    public int updSystemuser (SystemUser systemUser);//修改系统用户
    //系统用户操作end

    /*种子商店操作begin*/
    public List selectTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//查询商品明细

    public int insertTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//插入商品明细

    public int delTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//删除商品明细

    public int updTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//修改商品明细
    /*种子商店操作end*/
}
