package com.greenplatform.dao.owerMapper;

import com.greenplatform.model.TGreenGoldDzhz;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface OperateTableMapper {

    int createDzhzNewTable(Map paramsMap);

    int insert(Map paramsMap);
}
