package com.luo.service.plateImpl;

import com.luo.dao.PlateDao;
import com.luo.model.PlateUser;
import com.luo.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateServiceImpl implements PlateService {
    @Autowired
    PlateDao plateDao;
    @Override
    public PlateUser checkLogin(PlateUser plateUser) {
        PlateUser plateUser1 = plateDao.checkLogin(plateUser);
        System.out.println(plateUser1);
        return plateUser1;
    }
}
