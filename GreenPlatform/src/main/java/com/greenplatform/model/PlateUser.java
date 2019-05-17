package com.greenplatform.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "plate_user", schema = "greenplatform", catalog = "")
public class PlateUser {
    private String cUserid;
    private String cLoginname;
    private String cUsername;
    private String cPassword;
    private String cRylb;
    private String cRyzt;
    private String cZcfs;
    private String cZjlx;
    private String cZjhm;
    private String cSex;
    private String cJtzz;
    private String cPhone;
    private String cWxhm;
    private String cQq;
    private String cEmail;
    private String cBz;
    private String cZt;
    private String cCjuser;
    private Timestamp dCjsj;
    private String cXguser;
    private Timestamp dXgsj;
    private String cRydj;

    @Id
    @Column(name = "cUserid", nullable = false, length = 255)
    public String getcUserid() {
        return cUserid;
    }

    public void setcUserid(String cUserid) {
        this.cUserid = cUserid;
    }

    @Basic
    @Column(name = "cLoginname", nullable = true, length = 30)
    public String getcLoginname() {
        return cLoginname;
    }

    public void setcLoginname(String cLoginname) {
        this.cLoginname = cLoginname;
    }

    @Basic
    @Column(name = "cUsername", nullable = true, length = 800)
    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername;
    }

    @Basic
    @Column(name = "cPassword", nullable = true, length = 80)
    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    @Basic
    @Column(name = "cRylb", nullable = true, length = 1)
    public String getcRylb() {
        return cRylb;
    }

    public void setcRylb(String cRylb) {
        this.cRylb = cRylb;
    }

    @Basic
    @Column(name = "cRyzt", nullable = true, length = 1)
    public String getcRyzt() {
        return cRyzt;
    }

    public void setcRyzt(String cRyzt) {
        this.cRyzt = cRyzt;
    }

    @Basic
    @Column(name = "cZcfs", nullable = true, length = 1)
    public String getcZcfs() {
        return cZcfs;
    }

    public void setcZcfs(String cZcfs) {
        this.cZcfs = cZcfs;
    }

    @Basic
    @Column(name = "cZjlx", nullable = true, length = 1)
    public String getcZjlx() {
        return cZjlx;
    }

    public void setcZjlx(String cZjlx) {
        this.cZjlx = cZjlx;
    }

    @Basic
    @Column(name = "cZjhm", nullable = true, length = 30)
    public String getcZjhm() {
        return cZjhm;
    }

    public void setcZjhm(String cZjhm) {
        this.cZjhm = cZjhm;
    }

    @Basic
    @Column(name = "cSex", nullable = true, length = 1)
    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex;
    }

    @Basic
    @Column(name = "cJtzz", nullable = true, length = 100)
    public String getcJtzz() {
        return cJtzz;
    }

    public void setcJtzz(String cJtzz) {
        this.cJtzz = cJtzz;
    }

    @Basic
    @Column(name = "cPhone", nullable = true, length = 30)
    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    @Basic
    @Column(name = "cWxhm", nullable = true, length = 30)
    public String getcWxhm() {
        return cWxhm;
    }

    public void setcWxhm(String cWxhm) {
        this.cWxhm = cWxhm;
    }

    @Basic
    @Column(name = "cQq", nullable = true, length = 30)
    public String getcQq() {
        return cQq;
    }

    public void setcQq(String cQq) {
        this.cQq = cQq;
    }

    @Basic
    @Column(name = "cEmail", nullable = true, length = 255)
    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
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
        PlateUser plateUser = (PlateUser) o;
        return Objects.equals(cUserid, plateUser.cUserid) &&
                Objects.equals(cLoginname, plateUser.cLoginname) &&
                Objects.equals(cUsername, plateUser.cUsername) &&
                Objects.equals(cPassword, plateUser.cPassword) &&
                Objects.equals(cRylb, plateUser.cRylb) &&
                Objects.equals(cRyzt, plateUser.cRyzt) &&
                Objects.equals(cZcfs, plateUser.cZcfs) &&
                Objects.equals(cZjlx, plateUser.cZjlx) &&
                Objects.equals(cZjhm, plateUser.cZjhm) &&
                Objects.equals(cSex, plateUser.cSex) &&
                Objects.equals(cJtzz, plateUser.cJtzz) &&
                Objects.equals(cPhone, plateUser.cPhone) &&
                Objects.equals(cWxhm, plateUser.cWxhm) &&
                Objects.equals(cQq, plateUser.cQq) &&
                Objects.equals(cEmail, plateUser.cEmail) &&
                Objects.equals(cBz, plateUser.cBz) &&
                Objects.equals(cZt, plateUser.cZt) &&
                Objects.equals(cCjuser, plateUser.cCjuser) &&
                Objects.equals(dCjsj, plateUser.dCjsj) &&
                Objects.equals(cXguser, plateUser.cXguser) &&
                Objects.equals(dXgsj, plateUser.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cUserid, cLoginname, cUsername, cPassword, cRylb, cRyzt, cZcfs, cZjlx, cZjhm, cSex, cJtzz, cPhone, cWxhm, cQq, cEmail, cBz, cZt, cCjuser, dCjsj, cXguser, dXgsj);
    }

    @Override
    public String toString() {
        return "PlateUser{" +
                "cUserid='" + cUserid + '\'' +
                ", cLoginname='" + cLoginname + '\'' +
                ", cUsername='" + cUsername + '\'' +
                ", cPassword='" + cPassword + '\'' +
                ", cRylb='" + cRylb + '\'' +
                ", cRyzt='" + cRyzt + '\'' +
                ", cZcfs='" + cZcfs + '\'' +
                ", cZjlx='" + cZjlx + '\'' +
                ", cZjhm='" + cZjhm + '\'' +
                ", cSex='" + cSex + '\'' +
                ", cJtzz='" + cJtzz + '\'' +
                ", cPhone='" + cPhone + '\'' +
                ", cWxhm='" + cWxhm + '\'' +
                ", cQq='" + cQq + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", cBz='" + cBz + '\'' +
                ", cZt='" + cZt + '\'' +
                ", cCjuser='" + cCjuser + '\'' +
                ", dCjsj=" + dCjsj +
                ", cXguser='" + cXguser + '\'' +
                ", dXgsj=" + dXgsj +
                '}';
    }

    @Basic
    @Column(name = "cRydj", nullable = true, length = 1)
    public String getcRydj() {
        return cRydj;
    }

    public void setcRydj(String cRydj) {
        this.cRydj = cRydj;
    }
}
