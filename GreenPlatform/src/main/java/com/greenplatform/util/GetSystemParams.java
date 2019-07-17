package com.greenplatform.util;

import com.greenplatform.dao.PlateCodeXtcsMapper;
import com.greenplatform.model.PlateCodeXtcs;
import com.greenplatform.model.PlateCodeXtcsExample;
import com.greenplatform.model.PlateUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 根据系统参数key获取系统参数value
 */
public class GetSystemParams {
    @Autowired
    private static PlateCodeXtcsMapper plateCodeXtcsMapper;

    public static String getValue(String key){
        if (!(("").equals(key) || null == key)){
            PlateCodeXtcsExample plateCodeXtcsExample = new PlateCodeXtcsExample();
            PlateCodeXtcsExample.Criteria criteria = plateCodeXtcsExample.createCriteria();
            criteria.andCKeyEqualTo(key);
            criteria.andCZtEqualTo("1");

            List plateCodeXtcsList = plateCodeXtcsMapper.selectByExample(plateCodeXtcsExample);
            if (plateCodeXtcsList.size() == 1){
                PlateCodeXtcs plateCodeXtcs = (PlateCodeXtcs) plateCodeXtcsList.get(0);
                return plateCodeXtcs.getcValue();
            }else{
                return "";
            }
        }else{
            return "";
        }
    }
}
