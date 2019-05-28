package com.greenplatform.service.utilImpl;

import com.greenplatform.dao.UtilDao;
import com.greenplatform.model.PlateCodeDmz;
import com.greenplatform.model.TGreenSpSpmx;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UtilServiceImpl implements UtilService {
    @Autowired
    UtilDao utilDao;
    ReturnModel returnModel = new ReturnModel();

    @Override
    public PlateCodeDmz selectPlateCodeDmz(PlateCodeDmz plateCodeDmz) {
        List plateCodeDmzList = new ArrayList();
        try{
            plateCodeDmzList = utilDao.selectPlateCodeDmz(plateCodeDmz);
        }catch (Exception e){
            e.printStackTrace();
            plateCodeDmzList.add(null);
        }
        System.out.println("util获取代码值==="+plateCodeDmzList);
        return (PlateCodeDmz) plateCodeDmzList.get(0);
    }

    @Override
    public ReturnModel selectTGreenSpSpmx(TGreenSpSpmx tGreenSpSpmx) {
        return null;
    }
}
