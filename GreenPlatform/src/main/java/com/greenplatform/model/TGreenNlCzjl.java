package com.greenplatform.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_green_nl_czjl", schema = "greenplatform", catalog = "")
public class TGreenNlCzjl {
    private String cLsh;
    private String cCzje;
    private String cCznl;
    private Timestamp dCzsj;
    private String cSfcg;
    private String cCzfs;
    private String cCzzh;
    private String cDzzh;
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
    @Column(name = "cCzje", nullable = true, length = 255)
    public String getcCzje() {
        return cCzje;
    }

    public void setcCzje(String cCzje) {
        this.cCzje = cCzje;
    }

    @Basic
    @Column(name = "cCznl", nullable = true, length = 255)
    public String getcCznl() {
        return cCznl;
    }

    public void setcCznl(String cCznl) {
        this.cCznl = cCznl;
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
    @Column(name = "cSfcg", nullable = true, length = 1)
    public String getcSfcg() {
        return cSfcg;
    }

    public void setcSfcg(String cSfcg) {
        this.cSfcg = cSfcg;
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
    @Column(name = "cCzzh", nullable = true, length = 255)
    public String getcCzzh() {
        return cCzzh;
    }

    public void setcCzzh(String cCzzh) {
        this.cCzzh = cCzzh;
    }

    @Basic
    @Column(name = "cDzzh", nullable = true, length = 255)
    public String getcDzzh() {
        return cDzzh;
    }

    public void setcDzzh(String cDzzh) {
        this.cDzzh = cDzzh;
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
        TGreenNlCzjl that = (TGreenNlCzjl) o;
        return Objects.equals(cLsh, that.cLsh) &&
                Objects.equals(cCzje, that.cCzje) &&
                Objects.equals(cCznl, that.cCznl) &&
                Objects.equals(dCzsj, that.dCzsj) &&
                Objects.equals(cSfcg, that.cSfcg) &&
                Objects.equals(cCzfs, that.cCzfs) &&
                Objects.equals(cCzzh, that.cCzzh) &&
                Objects.equals(cDzzh, that.cDzzh) &&
                Objects.equals(cBz, that.cBz) &&
                Objects.equals(cZt, that.cZt) &&
                Objects.equals(cCjuser, that.cCjuser) &&
                Objects.equals(dCjsj, that.dCjsj) &&
                Objects.equals(cXguser, that.cXguser) &&
                Objects.equals(dXgsj, that.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cLsh, cCzje, cCznl, dCzsj, cSfcg, cCzfs, cCzzh, cDzzh, cBz, cZt, cCjuser, dCjsj, cXguser, dXgsj);
    }
}
