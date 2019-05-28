package com.greenplatform.dao;

import com.greenplatform.model.PlateCodeDmz;
import com.greenplatform.model.TGreenSpSpmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UtilDao {
    public List selectPlateCodeDmz (PlateCodeDmz plateCodeDmz);//查询代码值

    public List selectTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//查询商品明细
}
