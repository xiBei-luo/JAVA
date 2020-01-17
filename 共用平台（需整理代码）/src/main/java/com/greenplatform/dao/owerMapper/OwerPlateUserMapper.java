package com.greenplatform.dao.owerMapper;

import com.greenplatform.model.PlateUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OwerPlateUserMapper {
    List selectWebUser(PlateUser plateUser);
}
