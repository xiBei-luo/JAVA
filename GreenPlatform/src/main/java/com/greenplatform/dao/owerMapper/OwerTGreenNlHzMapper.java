package com.greenplatform.dao.owerMapper;

import com.greenplatform.model.TGreenNlHz;
import com.greenplatform.model.TGreenNlHzExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OwerTGreenNlHzMapper {
    List selectTGreenNlHzRank(Map params);
}