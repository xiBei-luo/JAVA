package com.greenplatform.dao.owerMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OwerTGreenNlCzjlMapper {
    List selectTGreenNlCzjl(Map params);
}
