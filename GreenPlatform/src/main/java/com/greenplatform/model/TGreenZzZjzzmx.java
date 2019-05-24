package com.greenplatform.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_green_zz_zjzzmx", schema = "greenplatform", catalog = "")
public class TGreenZzZjzzmx {
    private String cLsh;
    private String cUserid;
    private String cSpbm;
    private String cZjyy;
    private Timestamp dZjsj;
    private String cKjz;
    private String cSfjz;
    private Timestamp dJzsj;
    private String cBz;
    private String cZt;
    private String cCjuser;
    private Timestamp dCjsj;
    private String cXguser;
    private Timestamp dXgsj;

    @Id
    @Column(name = "cLsh", nullable = false, length = 255)
    public String getcLsh() {
        return cLsh;
    }

    public void setcLsh(String cLsh) {
        this.cLsh = cLsh;
    }

    @Basic
    @Column(name = "cUserid", nullable = false, length = 255)
    public String getcUserid() {
        return cUserid;
    }

    public void setcUserid(String cUserid) {
        this.cUserid = cUserid;
    }

    @Basic
    @Column(name = "cSpbm", nullable = false, length = 255)
    public String getcSpbm() {
        return cSpbm;
    }

    public void setcSpbm(String cSpbm) {
        this.cSpbm = cSpbm;
    }

    @Basic
    @Column(name = "cZjyy", nullable = true, length = 1)
    public String getcZjyy() {
        return cZjyy;
    }

    public void setcZjyy(String cZjyy) {
        this.cZjyy = cZjyy;
    }

    @Basic
    @Column(name = "dZjsj", nullable = true)
    public Timestamp getdZjsj() {
        return dZjsj;
    }

    public void setdZjsj(Timestamp dZjsj) {
        this.dZjsj = dZjsj;
    }

    @Basic
    @Column(name = "cKjz", nullable = true, length = 1)
    public String getcKjz() {
        return cKjz;
    }

    public void setcKjz(String cKjz) {
        this.cKjz = cKjz;
    }

    @Basic
    @Column(name = "cSfjz", nullable = true, length = 1)
    public String getcSfjz() {
        return cSfjz;
    }

    public void setcSfjz(String cSfjz) {
        this.cSfjz = cSfjz;
    }

    @Basic
    @Column(name = "dJzsj", nullable = true)
    public Timestamp getdJzsj() {
        return dJzsj;
    }

    public void setdJzsj(Timestamp dJzsj) {
        this.dJzsj = dJzsj;
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
        TGreenZzZjzzmx that = (TGreenZzZjzzmx) o;
        return Objects.equals(cLsh, that.cLsh) &&
                Objects.equals(cUserid, that.cUserid) &&
                Objects.equals(cSpbm, that.cSpbm) &&
                Objects.equals(cZjyy, that.cZjyy) &&
                Objects.equals(dZjsj, that.dZjsj) &&
                Objects.equals(cKjz, that.cKjz) &&
                Objects.equals(cSfjz, that.cSfjz) &&
                Objects.equals(dJzsj, that.dJzsj) &&
                Objects.equals(cBz, that.cBz) &&
                Objects.equals(cZt, that.cZt) &&
                Objects.equals(cCjuser, that.cCjuser) &&
                Objects.equals(dCjsj, that.dCjsj) &&
                Objects.equals(cXguser, that.cXguser) &&
                Objects.equals(dXgsj, that.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cLsh, cUserid, cSpbm, cZjyy, dZjsj, cKjz, cSfjz, dJzsj, cBz, cZt, cCjuser, dCjsj, cXguser, dXgsj);
    }

    @Override
    public String toString() {
        return "TGreenZzZjzzmx{" +
                "cLsh='" + cLsh + '\'' +
                ", cUserid='" + cUserid + '\'' +
                ", cSpbm='" + cSpbm + '\'' +
                ", cZjyy='" + cZjyy + '\'' +
                ", dZjsj=" + dZjsj +
                ", cKjz='" + cKjz + '\'' +
                ", cSfjz='" + cSfjz + '\'' +
                ", dJzsj=" + dJzsj +
                ", cBz='" + cBz + '\'' +
                ", cZt='" + cZt + '\'' +
                ", cCjuser='" + cCjuser + '\'' +
                ", dCjsj=" + dCjsj +
                ", cXguser='" + cXguser + '\'' +
                ", dXgsj=" + dXgsj +
                '}';
    }
}
