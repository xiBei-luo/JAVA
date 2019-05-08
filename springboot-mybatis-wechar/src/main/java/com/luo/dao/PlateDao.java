package com.luo.dao;

import com.luo.model.PlateUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlateDao {
    public PlateUser checkLogin(PlateUser plateUser);
}
