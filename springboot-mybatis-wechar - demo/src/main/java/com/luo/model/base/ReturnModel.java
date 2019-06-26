package com.luo.model.base;

public class ReturnModel {
    private int flag;
    private String msg;
    private Object object;

    public ReturnModel() {
    }

    public ReturnModel(int flag, String msg, Object object) {
        this.flag = flag;
        this.msg = msg;
        this.object = object;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ReturnModel{" +
                "flag=" + flag +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                '}';
    }
}
