package com.greenplatform.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "plate_yw_lx_menu", schema = "greenplatform", catalog = "")
public class PlateYwLxMenu {
    private String cYwlxdm;
    private String cMenudm;
    private String cMenumc;
    private String cZt;
    private String cBz;
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
    @Column(name = "cMenudm", nullable = true, length = 255)
    public String getcMenudm() {
        return cMenudm;
    }

    public void setcMenudm(String cMenudm) {
        this.cMenudm = cMenudm;
    }

    @Basic
    @Column(name = "cMenumc", nullable = true, length = 255)
    public String getcMenumc() {
        return cMenumc;
    }

    public void setcMenumc(String cMenumc) {
        this.cMenumc = cMenumc;
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
    @Column(name = "cBz", nullable = true, length = 255)
    public String getcBz() {
        return cBz;
    }

    public void setcBz(String cBz) {
        this.cBz = cBz;
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
        PlateYwLxMenu that = (PlateYwLxMenu) o;
        return Objects.equals(cYwlxdm, that.cYwlxdm) &&
                Objects.equals(cMenudm, that.cMenudm) &&
                Objects.equals(cMenumc, that.cMenumc) &&
                Objects.equals(cZt, that.cZt) &&
                Objects.equals(cBz, that.cBz) &&
                Objects.equals(cCjuser, that.cCjuser) &&
                Objects.equals(dCjsj, that.dCjsj) &&
                Objects.equals(cXguser, that.cXguser) &&
                Objects.equals(dXgsj, that.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cYwlxdm, cMenudm, cMenumc, cZt, cBz, cCjuser, dCjsj, cXguser, dXgsj);
    }

    @Override
    public String toString() {
        return "PlateYwLxMenu{" +
                "cYwlxdm='" + cYwlxdm + '\'' +
                ", cMenudm='" + cMenudm + '\'' +
                ", cMenumc='" + cMenumc + '\'' +
                ", cZt='" + cZt + '\'' +
                ", cBz='" + cBz + '\'' +
                ", cCjuser='" + cCjuser + '\'' +
                ", dCjsj=" + dCjsj +
                ", cXguser='" + cXguser + '\'' +
                ", dXgsj=" + dXgsj +
                '}';
    }
}
