package com.greenplatform.dao;

import com.greenplatform.model.SystemUser;
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
}
