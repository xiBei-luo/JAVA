package com.greenplatform.util;

import com.greenplatform.model.PlateCodeDmz;
import com.greenplatform.model.base.ReturnModel;
import com.greenplatform.service.PlateService;
import com.greenplatform.service.plateImpl.PlateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetDmmc {
    @Autowired
    PlateService plateService;

    public static String getDmmcByDm(String dmlb,String cDm){
        PlateService plateService = new PlateServiceImpl();
        PlateCodeDmz plateCodeDmz = new PlateCodeDmz();

        plateCodeDmz.setcDmlb(dmlb);
        plateCodeDmz.setcDm(cDm);
        System.out.println(plateCodeDmz);
        ReturnModel returnModel =  plateService.selectPlateCodeDmz(plateCodeDmz);
        System.out.println(returnModel);

        return null;
    }
}
