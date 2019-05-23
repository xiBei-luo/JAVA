package com.greenplatform.model.ywModel;

public class TUserAccount {
    private String cUserid;
    private String cUserGrade;
    private String cUserNlTotal;
    private String cUserSeed;
    private String cUserRwProgress;

    public TUserAccount() {
    }

    public TUserAccount(String cUserid, String cUserGrade, String cUserNlTotal, String cUserSeed, String cUserRwProgress) {
        this.cUserid = cUserid;
        this.cUserGrade = cUserGrade;
        this.cUserNlTotal = cUserNlTotal;
        this.cUserSeed = cUserSeed;
        this.cUserRwProgress = cUserRwProgress;
    }

    public String getcUserid() {
        return cUserid;
    }

    public void setcUserid(String cUserid) {
        this.cUserid = cUserid;
    }

    public String getcUserGrade() {
        return cUserGrade;
    }

    public void setcUserGrade(String cUserGrade) {
        this.cUserGrade = cUserGrade;
    }

    public String getcUserNlTotal() {
        return cUserNlTotal;
    }

    public void setcUserNlTotal(String cUserNlTotal) {
        this.cUserNlTotal = cUserNlTotal;
    }

    public String getcUserSeed() {
        return cUserSeed;
    }

    public void setcUserSeed(String cUserSeed) {
        this.cUserSeed = cUserSeed;
    }

    public String getcUserRwProgress() {
        return cUserRwProgress;
    }

    public void setcUserRwProgress(String cUserRwProgress) {
        this.cUserRwProgress = cUserRwProgress;
    }

    @Override
    public String toString() {
        return "TUserAccount{" +
                "cUserid='" + cUserid + '\'' +
                ", cUserGrade='" + cUserGrade + '\'' +
                ", cUserNlTotal='" + cUserNlTotal + '\'' +
                ", cUserSeed='" + cUserSeed + '\'' +
                ", cUserRwProgress='" + cUserRwProgress + '\'' +
                '}';
    }
}
