package com.luo.model;

/**
 * Created by Luowenlv on 2018/12/7,9:57
 * 定义返回信息
 */
public class ReturnInfoUtil {
    private Integer retFlag;
    private String retMsg;
    private Object retVal;

    public ReturnInfoUtil(Integer retFlag, String retMsg, Object retVal) {
        this.retFlag = retFlag;
        this.retMsg = retMsg;
        this.retVal = retVal;
    }

    public ReturnInfoUtil() {
    }

    public Integer getRetFlag() {
        return retFlag;
    }

    public void setRetFlag(Integer retFlag) {
        this.retFlag = retFlag;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Object getRetVal() {
        return retVal;
    }

    public void setRetVal(Object retVal) {
        this.retVal = retVal;
    }

    @Override
    public String toString() {
        return "ReturnInfoUtil{" +
                "retFlag=" + retFlag +
                ", retMsg='" + retMsg + '\'' +
                ", retVal=" + retVal +
                '}';
    }
}
