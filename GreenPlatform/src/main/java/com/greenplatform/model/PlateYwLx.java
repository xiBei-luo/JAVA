package com.greenplatform.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "plate_yw_lx", schema = "greenplatform", catalog = "")
public class PlateYwLx {
    private String cYwlxdm;
    private String cYwlxmc;
    private String cYwlxmcjc;
    private String cBz;
    private String cZt;
    private String cCjuser;
    private Timestamp dCjsj;
    private String cXguser;
    private Timestamp dXgsj;

    @Basic
    @Column(name = "cYwlxdm", nullable = true, length = 255)
    public String getcYwlxdm() {
        return cYwlxdm;
    }

    public void setcYwlxdm(String cYwlxdm) {
        this.cYwlxdm = cYwlxdm;
    }

    @Basic
    @Column(name = "cYwlxmc", nullable = true, length = 255)
    public String getcYwlxmc() {
        return cYwlxmc;
    }

    public void setcYwlxmc(String cYwlxmc) {
        this.cYwlxmc = cYwlxmc;
    }

    @Basic
    @Column(name = "cYwlxmcjc", nullable = true, length = 255)
    public String getcYwlxmcjc() {
        return cYwlxmcjc;
    }

    public void setcYwlxmcjc(String cYwlxmcjc) {
        this.cYwlxmcjc = cYwlxmcjc;
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
        PlateYwLx plateYwLx = (PlateYwLx) o;
        return Objects.equals(cYwlxdm, plateYwLx.cYwlxdm) &&
                Objects.equals(cYwlxmc, plateYwLx.cYwlxmc) &&
                Objects.equals(cYwlxmcjc, plateYwLx.cYwlxmcjc) &&
                Objects.equals(cBz, plateYwLx.cBz) &&
                Objects.equals(cZt, plateYwLx.cZt) &&
                Objects.equals(cCjuser, plateYwLx.cCjuser) &&
                Objects.equals(dCjsj, plateYwLx.dCjsj) &&
                Objects.equals(cXguser, plateYwLx.cXguser) &&
                Objects.equals(dXgsj, plateYwLx.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cYwlxdm, cYwlxmc, cYwlxmcjc, cBz, cZt, cCjuser, dCjsj, cXguser, dXgsj);
    }

    @Override
    public String toString() {
        return "PlateYwLx{" +
                "cYwlxdm='" + cYwlxdm + '\'' +
                ", cYwlxmc='" + cYwlxmc + '\'' +
                ", cYwlxmcjc='" + cYwlxmcjc + '\'' +
                ", cBz='" + cBz + '\'' +
                ", cZt='" + cZt + '\'' +
                ", cCjuser='" + cCjuser + '\'' +
                ", dCjsj=" + dCjsj +
                ", cXguser='" + cXguser + '\'' +
                ", dXgsj=" + dXgsj +
                '}';
    }
}
