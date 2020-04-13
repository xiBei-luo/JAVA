package com.plate.publicmag.util.returnUtil;


import com.plate.publicmag.model.baseModel.ReturnModel;

public class ReturnModelHandler {

    public static ReturnModel success(Object object){
        ReturnModel returnModel = new ReturnModel();
        returnModel.setStatus(1);
        returnModel.setMsg(null);
        returnModel.setData(object);
        return returnModel;



    }

    public static ReturnModel error(String msg){
        ReturnModel returnModel = new ReturnModel();
        returnModel.setStatus(0);
        returnModel.setMsg(msg);
        returnModel.setData(null);
        return returnModel;
    }

    public static ReturnModel systemError(){
        ReturnModel returnModel = new ReturnModel();
        returnModel.setStatus(1);
        returnModel.setMsg("操作失败，系统错误");
        returnModel.setData(null);
        return returnModel;
    }
}
