package com.greenplatform.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "plate_log", schema = "greenplatform", catalog = "")
public class PlateLog {
    private String cCzrzbh;
    private String cCzr;
    private Timestamp dCzsj;
    private String cCzfs;
    private String cMethod;
    private String cParams;
    private String cIp;
    private String cCjuser;
    private Timestamp dCjsj;
    private String cXguser;
    private Timestamp dXgsj;

    @Id
    @Column(name = "cCzrzbh", nullable = false, length = 255)
    public String getcCzrzbh() {
        return cCzrzbh;
    }

    public void setcCzrzbh(String cCzrzbh) {
        this.cCzrzbh = cCzrzbh;
    }

    @Basic
    @Column(name = "cCzr", nullable = true, length = 255)
    public String getcCzr() {
        return cCzr;
    }

    public void setcCzr(String cCzr) {
        this.cCzr = cCzr;
    }

    @Basic
    @Column(name = "dCzsj", nullable = true)
    public Timestamp getdCzsj() {
        return dCzsj;
    }

    public void setdCzsj(Timestamp dCzsj) {
        this.dCzsj = dCzsj;
    }

    @Basic
    @Column(name = "cCzfs", nullable = true, length = 1)
    public String getcCzfs() {
        return cCzfs;
    }

    public void setcCzfs(String cCzfs) {
        this.cCzfs = cCzfs;
    }

    @Basic
    @Column(name = "cMethod", nullable = true, length = 255)
    public String getcMethod() {
        return cMethod;
    }

    public void setcMethod(String cMethod) {
        this.cMethod = cMethod;
    }

    @Basic
    @Column(name = "cParams", nullable = true, length = 4000)
    public String getcParams() {
        return cParams;
    }

    public void setcParams(String cParams) {
        this.cParams = cParams;
    }

    @Basic
    @Column(name = "cIp", nullable = true, length = 255)
    public String getcIp() {
        return cIp;
    }

    public void setcIp(String cIp) {
        this.cIp = cIp;
    }

    @Basic
    @Column(name = "cCjuser", nullable = true, length = 255)
    public String getcCjuser() {
        return cCjuser;
    }

    public void setcCjuser(String cCjuser) {
        this.cCjuser = cCjuser;
    }

    @Basic
    @Column(name = "dCjsj", nullable = true)
    public Timestamp getdCjsj() {
        return dCjsj;
    }

    public void setdCjsj(Timestamp dCjsj) {
        this.dCjsj = dCjsj;
    }

    @Basic
    @Column(name = "cXguser", nullable = true, length = 255)
    public String getcXguser() {
        return cXguser;
    }

    public void setcXguser(String cXguser) {
        this.cXguser = cXguser;
    }

    @Basic
    @Column(name = "dXgsj", nullable = true)
    public Timestamp getdXgsj() {
        return dXgsj;
    }

    public void setdXgsj(Timestamp dXgsj) {
        this.dXgsj = dXgsj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateLog plateLog = (PlateLog) o;
        return Objects.equals(cCzrzbh, plateLog.cCzrzbh) &&
                Objects.equals(cCzr, plateLog.cCzr) &&
                Objects.equals(dCzsj, plateLog.dCzsj) &&
                Objects.equals(cCzfs, plateLog.cCzfs) &&
                Objects.equals(cMethod, plateLog.cMethod) &&
                Objects.equals(cParams, plateLog.cParams) &&
                Objects.equals(cIp, plateLog.cIp) &&
                Objects.equals(cCjuser, plateLog.cCjuser) &&
                Objects.equals(dCjsj, plateLog.dCjsj) &&
                Objects.equals(cXguser, plateLog.cXguser) &&
                Objects.equals(dXgsj, plateLog.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cCzrzbh, cCzr, dCzsj, cCzfs, cMethod, cParams, cIp, cCjuser, dCjsj, cXguser, dXgsj);
    }

    @Override
    public String toString() {
        return "PlateLog{" +
                "cCzrzbh='" + cCzrzbh + '\'' +
                ", cCzr='" + cCzr + '\'' +
                ", dCzsj=" + dCzsj +
                ", cCzfs='" + cCzfs + '\'' +
                ", cMethod='" + cMethod + '\'' +
                ", cParams='" + cParams + '\'' +
                ", cIp='" + cIp + '\'' +
                ", cCjuser='" + cCjuser + '\'' +
                ", dCjsj=" + dCjsj +
                ", cXguser='" + cXguser + '\'' +
                ", dXgsj=" + dXgsj +
                '}';
    }
}
