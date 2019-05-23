package com.greenplatform.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_green_nl_txjl", schema = "greenplatform", catalog = "")
public class TGreenNlTxjl {
    private String cLsh;
    private String cTxje;
    private String cTxnl;
    private Timestamp dTxsj;
    private String cSfcg;
    private String cTxfs;
    private String cTxzh;
    private String cZfzh;
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
    @Column(name = "cTxje", nullable = true, length = 255)
    public String getcTxje() {
        return cTxje;
    }

    public void setcTxje(String cTxje) {
        this.cTxje = cTxje;
    }

    @Basic
    @Column(name = "cTxnl", nullable = true, length = 255)
    public String getcTxnl() {
        return cTxnl;
    }

    public void setcTxnl(String cTxnl) {
        this.cTxnl = cTxnl;
    }

    @Basic
    @Column(name = "dTxsj", nullable = true)
    public Timestamp getdTxsj() {
        return dTxsj;
    }

    public void setdTxsj(Timestamp dTxsj) {
        this.dTxsj = dTxsj;
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
    @Column(name = "cTxfs", nullable = true, length = 255)
    public String getcTxfs() {
        return cTxfs;
    }

    public void setcTxfs(String cTxfs) {
        this.cTxfs = cTxfs;
    }

    @Basic
    @Column(name = "cTxzh", nullable = true, length = 255)
    public String getcTxzh() {
        return cTxzh;
    }

    public void setcTxzh(String cTxzh) {
        this.cTxzh = cTxzh;
    }

    @Basic
    @Column(name = "cZfzh", nullable = true, length = 255)
    public String getcZfzh() {
        return cZfzh;
    }

    public void setcZfzh(String cZfzh) {
        this.cZfzh = cZfzh;
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
        TGreenNlTxjl that = (TGreenNlTxjl) o;
        return Objects.equals(cLsh, that.cLsh) &&
                Objects.equals(cTxje, that.cTxje) &&
                Objects.equals(cTxnl, that.cTxnl) &&
                Objects.equals(dTxsj, that.dTxsj) &&
                Objects.equals(cSfcg, that.cSfcg) &&
                Objects.equals(cTxfs, that.cTxfs) &&
                Objects.equals(cTxzh, that.cTxzh) &&
                Objects.equals(cZfzh, that.cZfzh) &&
                Objects.equals(cBz, that.cBz) &&
                Objects.equals(cZt, that.cZt) &&
                Objects.equals(cCjuser, that.cCjuser) &&
                Objects.equals(dCjsj, that.dCjsj) &&
                Objects.equals(cXguser, that.cXguser) &&
                Objects.equals(dXgsj, that.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cLsh, cTxje, cTxnl, dTxsj, cSfcg, cTxfs, cTxzh, cZfzh, cBz, cZt, cCjuser, dCjsj, cXguser, dXgsj);
    }
}
