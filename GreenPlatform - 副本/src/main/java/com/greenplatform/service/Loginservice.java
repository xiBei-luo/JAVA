package com.greenplatform.service;

import com.greenplatform.model.PlateUser;
import com.greenplatform.model.baseModel.ReturnModel;
import org.springframework.stereotype.Service;


public interface Loginservice {
    ReturnModel checkLogin(PlateUser plateUser);
}
