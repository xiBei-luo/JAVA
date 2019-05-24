package com.greenplatform.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "plate_code_dmz", schema = "greenplatform", catalog = "")
@IdClass(PlateCodeDmzPK.class)
public class PlateCodeDmz {
    private String cDmlb;
    private String cDm;
    private String cDmmc;
    private String cSort;
    private String cBz;
    private String cZt;
    private String cCjuser;
    private Timestamp dCjsj;
    private String cXguser;
    private Timestamp dXgsj;

    @Id
    @Column(name = "cDmlb", nullable = false, length = 255)
    public String getcDmlb() {
        return cDmlb;
    }

    public void setcDmlb(String cDmlb) {
        this.cDmlb = cDmlb;
    }

    @Id
    @Column(name = "cDm", nullable = false, length = 255)
    public String getcDm() {
        return cDm;
    }

    public void setcDm(String cDm) {
        this.cDm = cDm;
    }

    @Basic
    @Column(name = "cDmmc", nullable = true, length = 255)
    public String getcDmmc() {
        return cDmmc;
    }

    public void setcDmmc(String cDmmc) {
        this.cDmmc = cDmmc;
    }

    @Basic
    @Column(name = "cSort", nullable = true, length = 255)
    public String getcSort() {
        return cSort;
    }

    public void setcSort(String cSort) {
        this.cSort = cSort;
    }

    @Basic
    @Column(name = "cBz", nullable = true, length = 255)
    public String getcBz() {
        return cBz;
    }

    public void setcBz(String cBz) {
        this.cBz = cBz;
    }

    @Basic
    @Column(name = "cZt", nullable = true, length = 255)
    public String getcZt() {
        return cZt;
    }

    public void setcZt(String cZt) {
        this.cZt = cZt;
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
        PlateCodeDmz that = (PlateCodeDmz) o;
        return Objects.equals(cDmlb, that.cDmlb) &&
                Objects.equals(cDm, that.cDm) &&
                Objects.equals(cDmmc, that.cDmmc) &&
                Objects.equals(cSort, that.cSort) &&
                Objects.equals(cBz, that.cBz) &&
                Objects.equals(cZt, that.cZt) &&
                Objects.equals(cCjuser, that.cCjuser) &&
                Objects.equals(dCjsj, that.dCjsj) &&
                Objects.equals(cXguser, that.cXguser) &&
                Objects.equals(dXgsj, that.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cDmlb, cDm, cDmmc, cSort, cBz, cZt, cCjuser, dCjsj, cXguser, dXgsj);
    }


    @Override
    public String toString() {
        return "PlateCodeDmz{" +
                "cDmlb='" + cDmlb + '\'' +
                ", cDm='" + cDm + '\'' +
                ", cDmmc='" + cDmmc + '\'' +
                ", cSort='" + cSort + '\'' +
                ", cBz='" + cBz + '\'' +
                ", cZt='" + cZt + '\'' +
                ", cCjuser='" + cCjuser + '\'' +
                ", dCjsj=" + dCjsj +
                ", cXguser='" + cXguser + '\'' +
                ", dXgsj=" + dXgsj +
                '}';
    }
}
