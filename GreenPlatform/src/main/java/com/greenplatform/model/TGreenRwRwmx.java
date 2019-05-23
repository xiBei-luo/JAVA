package com.greenplatform.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_green_rw_rwmx", schema = "greenplatform", catalog = "")
@IdClass(TGreenRwRwmxPK.class)
public class TGreenRwRwmx {
    private String cUserid;
    private String cRwlb;
    private String cRwsj;
    private String cLjrwcs;
    private String cBz;
    private String cCjuser;
    private Timestamp dCjsj;
    private String cXguser;
    private Timestamp dXgsj;

    @Id
    @Column(name = "cUserid", nullable = false, length = 255)
    public String getcUserid() {
        return cUserid;
    }

    public void setcUserid(String cUserid) {
        this.cUserid = cUserid;
    }

    @Id
    @Column(name = "cRwlb", nullable = false, length = 1)
    public String getcRwlb() {
        return cRwlb;
    }

    public void setcRwlb(String cRwlb) {
        this.cRwlb = cRwlb;
    }

    @Id
    @Column(name = "cRwsj", nullable = false, length = 255)
    public String getcRwsj() {
        return cRwsj;
    }

    public void setcRwsj(String cRwsj) {
        this.cRwsj = cRwsj;
    }

    @Basic
    @Column(name = "cLjrwcs", nullable = true, length = 255)
    public String getcLjrwcs() {
        return cLjrwcs;
    }

    public void setcLjrwcs(String cLjrwcs) {
        this.cLjrwcs = cLjrwcs;
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
        TGreenRwRwmx that = (TGreenRwRwmx) o;
        return Objects.equals(cUserid, that.cUserid) &&
                Objects.equals(cRwlb, that.cRwlb) &&
                Objects.equals(cRwsj, that.cRwsj) &&
                Objects.equals(cLjrwcs, that.cLjrwcs) &&
                Objects.equals(cBz, that.cBz) &&
                Objects.equals(cCjuser, that.cCjuser) &&
                Objects.equals(dCjsj, that.dCjsj) &&
                Objects.equals(cXguser, that.cXguser) &&
                Objects.equals(dXgsj, that.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cUserid, cRwlb, cRwsj, cLjrwcs, cBz, cCjuser, dCjsj, cXguser, dXgsj);
    }
}
