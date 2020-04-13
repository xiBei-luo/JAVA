package com.greenplatform.util.returnUtil;

import com.greenplatform.model.base.ReturnModel;

public class ReturnModelHandler {

    public static ReturnModel success(Object object){
        ReturnModel returnModel = new ReturnModel();
        returnModel.setFlag(0);
        returnModel.setMsg(null);
        returnModel.setObject(object);
        return returnModel;
    }

    public static ReturnModel error(String msg){
        ReturnModel returnModel = new ReturnModel();
        returnModel.setFlag(1);
        returnModel.setMsg(msg);
        returnModel.setObject(null);
        return returnModel;
    }

    public static ReturnModel systemError(){
        ReturnModel returnModel = new ReturnModel();
        returnModel.setFlag(1);
        returnModel.setMsg("操作失败，系统错误");
        returnModel.setObject(null);
        return returnModel;
    }
}
