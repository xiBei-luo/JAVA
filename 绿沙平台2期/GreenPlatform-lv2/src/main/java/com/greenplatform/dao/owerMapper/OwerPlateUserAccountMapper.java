package com.greenplatform.dao.owerMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OwerPlateUserAccountMapper {
    //基本信息
    List selectLoginuserAccountJbxx(Map params);
    //我的徒弟
    List selectLoginuserAccountWdtd(Map params);
}
