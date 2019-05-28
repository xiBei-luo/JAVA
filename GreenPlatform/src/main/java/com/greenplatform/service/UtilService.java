package com.greenplatform.service;


import com.greenplatform.model.PlateCodeDmz;
import com.greenplatform.model.TGreenSpSpmx;
import com.greenplatform.model.base.ReturnModel;


public interface UtilService {
    public PlateCodeDmz selectPlateCodeDmz (PlateCodeDmz plateCodeDmz);//查询代码值

    public ReturnModel selectTGreenSpSpmx (TGreenSpSpmx tGreenSpSpmx);//查询商品明细
}
