package com.greenplatform.dao.owerMapper;

import com.greenplatform.model.TGreenSpSpmx;

import java.util.List;
import java.util.Map;

public interface OwerTGreenSpSpmxMapper {
    //当前登陆人的种子
    List selectOwerZz(Map paramsMap);
    //当前登陆人未种植的种子
    List selectExaZz(Map paramsMap);

    List selectNoZzSumDay(Map paramsMap);

}
