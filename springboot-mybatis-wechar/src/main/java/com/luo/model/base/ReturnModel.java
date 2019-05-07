package com.luo.model.base;

/**
 * Created by Luowenlv on 2019/5/7,9:35
 * 统一返回结果
 */
public class ReturnModel {
    private String flag;
    private String msg;
    private String data;

    public ReturnModel() {
    }

    public ReturnModel(String flag, String msg, String data) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
