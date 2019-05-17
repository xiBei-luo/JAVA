package com.greenplatform.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_green_sp_spmx", schema = "greenplatform", catalog = "")
public class TGreenSpSpmx {
    private String cSpbh;
    private String cSpmc;
    private String cSpms;
    private String cSpjg;
    private String cSpdw;
    private String cBz;
    private String cZt;
    private String cCjuser;
    private Timestamp dCjsj;
    private String cXguser;
    private Timestamp dXgsj;

    @Id
    @Column(name = "cSpbh", nullable = false, length = 255)
    public String getcSpbh() {
        return cSpbh;
    }

    public void setcSpbh(String cSpbh) {
        this.cSpbh = cSpbh;
    }

    @Basic
    @Column(name = "cSpmc", nullable = true, length = 255)
    public String getcSpmc() {
        return cSpmc;
    }

    public void setcSpmc(String cSpmc) {
        this.cSpmc = cSpmc;
    }

    @Basic
    @Column(name = "cSpms", nullable = true, length = 255)
    public String getcSpms() {
        return cSpms;
    }

    public void setcSpms(String cSpms) {
        this.cSpms = cSpms;
    }

    @Basic
    @Column(name = "cSpjg", nullable = true, length = 255)
    public String getcSpjg() {
        return cSpjg;
    }

    public void setcSpjg(String cSpjg) {
        this.cSpjg = cSpjg;
    }

    @Basic
    @Column(name = "cSpdw", nullable = true, length = 255)
    public String getcSpdw() {
        return cSpdw;
    }

    public void setcSpdw(String cSpdw) {
        this.cSpdw = cSpdw;
    }

    @Basic
    @Column(name = "cBz", nullable = true, length = 2000)
    public String getcBz() {
        return cBz;
    }

    public void setcBz(String cBz) {
        this.cBz = cBz;
    }

    @Basic
    @Column(name = "cZt", nullable = true, length = 1)
    public String getcZt() {
        return cZt;
    }

    public void setcZt(String cZt) {
        this.cZt = cZt;
    }

    @Basic
    @Column(name = "cCjuser", nullable = true, length = 11)
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
    @Column(name = "cXguser", nullable = true, length = 11)
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
        TGreenSpSpmx that = (TGreenSpSpmx) o;
        return Objects.equals(cSpbh, that.cSpbh) &&
                Objects.equals(cSpmc, that.cSpmc) &&
                Objects.equals(cSpms, that.cSpms) &&
                Objects.equals(cSpjg, that.cSpjg) &&
                Objects.equals(cSpdw, that.cSpdw) &&
                Objects.equals(cBz, that.cBz) &&
                Objects.equals(cZt, that.cZt) &&
                Objects.equals(cCjuser, that.cCjuser) &&
                Objects.equals(dCjsj, that.dCjsj) &&
                Objects.equals(cXguser, that.cXguser) &&
                Objects.equals(dXgsj, that.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cSpbh, cSpmc, cSpms, cSpjg, cSpdw, cBz, cZt, cCjuser, dCjsj, cXguser, dXgsj);
    }

    @Override
    public String toString() {
        return "TGreenSpSpmx{" +
                "cSpbh='" + cSpbh + '\'' +
                ", cSpmc='" + cSpmc + '\'' +
                ", cSpms='" + cSpms + '\'' +
                ", cSpjg='" + cSpjg + '\'' +
                ", cSpdw='" + cSpdw + '\'' +
                ", cBz='" + cBz + '\'' +
                ", cZt='" + cZt + '\'' +
                ", cCjuser='" + cCjuser + '\'' +
                ", dCjsj=" + dCjsj +
                ", cXguser='" + cXguser + '\'' +
                ", dXgsj=" + dXgsj +
                '}';
    }
}
