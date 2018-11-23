package com.luo.model;

/**
 * Created by Luowenlv on 2018/9/10,15:34
 */
public class BankModel {
    private Integer id;
    private String docNumber;
    private String account;
    private String firstTime;
    private String flag;
    private String unit;
    private String remark;
    private String info;
    private String moneyOut;
    private String moneyIn;
    private String timeEnd;

    public BankModel() {
    }

    public BankModel(Integer id, String docNumber, String account, String firstTime, String flag, String unit, String remark, String info, String moneyOut, String moneyIn, String timeEnd) {
        this.id = id;
        this.docNumber = docNumber;
        this.account = account;
        this.firstTime = firstTime;
        this.flag = flag;
        this.unit = unit;
        this.remark = remark;
        this.info = info;
        this.moneyOut = moneyOut;
        this.moneyIn = moneyIn;
        this.timeEnd = timeEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMoneyOut() {
        return moneyOut;
    }

    public void setMoneyOut(String moneyOut) {
        this.moneyOut = moneyOut;
    }

    public String getMoneyIn() {
        return moneyIn;
    }

    public void setMoneyIn(String moneyIn) {
        this.moneyIn = moneyIn;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "BankModel{" +
                "id=" + id +
                ", docNumber='" + docNumber + '\'' +
                ", account='" + account + '\'' +
                ", firstTime='" + firstTime + '\'' +
                ", flag='" + flag + '\'' +
                ", unit='" + unit + '\'' +
                ", remark='" + remark + '\'' +
                ", info='" + info + '\'' +
                ", moneyOut='" + moneyOut + '\'' +
                ", moneyIn='" + moneyIn + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                '}';
    }
}
