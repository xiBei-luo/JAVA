package com.greenplatform.service.utilImpl;


import com.greenplatform.dao.PlateCodeXtcsMapper;
import com.greenplatform.model.PlateCodeXtcs;
import com.greenplatform.model.PlateCodeXtcsExample;
import com.greenplatform.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilServiceImpl implements UtilService {
    @Autowired
    private PlateCodeXtcsMapper plateCodeXtcsMapper;

    @Override
    public PlateCodeXtcs getPlateCodeXtcsObject(String key){
        if (!(("").equals(key) || null == key)){
            PlateCodeXtcsExample plateCodeXtcsExample = new PlateCodeXtcsExample();
            PlateCodeXtcsExample.Criteria criteria = plateCodeXtcsExample.createCriteria();
            criteria.andCKeyEqualTo(key);
            criteria.andCZtEqualTo("1");

            List plateCodeXtcsList = plateCodeXtcsMapper.selectByExample(plateCodeXtcsExample);
            if (plateCodeXtcsList.size() == 1){
                PlateCodeXtcs plateCodeXtcs = (PlateCodeXtcs) plateCodeXtcsList.get(0);
                return plateCodeXtcs;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
}
