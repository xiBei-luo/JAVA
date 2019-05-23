package com.greenplatform.dao;

import com.greenplatform.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SystemDao {
    //系统用户操作begin
    public List selectSystemuser (SystemUser systemUser);//查询系统用户

    public int insertSystemUser (SystemUser systemUser);//插入系统用户信息

    public int delSystemuser (SystemUser systemUser);//删除系统用户信息

    public int updSystemuser (SystemUser systemUser);//修改系统用户

    /*种子商店操作begin*/
    public List selectTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//查询商品明细

    public int insertTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//插入商品明细

    public int delTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//删除商品明细

    public int updTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//修改商品明细

    //能量汇总表操作
    public List selectTGreenNlHz (TGreenNlHz tGreenNlHz);//查询能量汇总表

    public int insertTGreenNlHz (TGreenNlHz tGreenNlHz);//插入能量汇总表

    public int delTGreenNlHz (TGreenNlHz tGreenNlHz);//删除能量汇总表

    public int updTGreenNlHz (TGreenNlHz tGreenNlHz);//修改能量汇总表

    //能量增加表操作
    public List selectTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//查询能量增加明细

    public int insertTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//插入能量增加明细

    public int delTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//删除能量增加明细

    public int updTGreenNlZjnlmx (TGreenNlZjnlmx tGreenNlZjnlmx);//修改能量增加明细

    //任务明细
    public List selectTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//查询任务明细

    public int insertTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//插入任务明细

    public int delTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//删除任务明细

    public int updTGreenRwRwmx (TGreenRwRwmx tGreenRwRwmx);//修改任务明细

}
