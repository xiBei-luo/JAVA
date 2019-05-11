package com.greenplatform.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "plate_log", schema = "greenplatform", catalog = "")
public class PlateLog {
    private String cCzrzbh;
    private String cTable;
    private String cTablekey;
    private String cKeyvalue;
    private String cColumn;
    private String cColumnname;
    private String cCzfs;
    private String cOldvalue;
    private String cNewvalue;
    private String cBgr;
    private String cBgrxm;
    private Timestamp dBgsj;
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
    @Column(name = "cTable", nullable = true, length = 255)
    public String getcTable() {
        return cTable;
    }

    public void setcTable(String cTable) {
        this.cTable = cTable;
    }

    @Basic
    @Column(name = "cTablekey", nullable = true, length = 255)
    public String getcTablekey() {
        return cTablekey;
    }

    public void setcTablekey(String cTablekey) {
        this.cTablekey = cTablekey;
    }

    @Basic
    @Column(name = "cKeyvalue", nullable = true, length = 255)
    public String getcKeyvalue() {
        return cKeyvalue;
    }

    public void setcKeyvalue(String cKeyvalue) {
        this.cKeyvalue = cKeyvalue;
    }

    @Basic
    @Column(name = "cColumn", nullable = true, length = 255)
    public String getcColumn() {
        return cColumn;
    }

    public void setcColumn(String cColumn) {
        this.cColumn = cColumn;
    }

    @Basic
    @Column(name = "cColumnname", nullable = true, length = 255)
    public String getcColumnname() {
        return cColumnname;
    }

    public void setcColumnname(String cColumnname) {
        this.cColumnname = cColumnname;
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
    @Column(name = "cOldvalue", nullable = true, length = 255)
    public String getcOldvalue() {
        return cOldvalue;
    }

    public void setcOldvalue(String cOldvalue) {
        this.cOldvalue = cOldvalue;
    }

    @Basic
    @Column(name = "cNewvalue", nullable = true, length = 255)
    public String getcNewvalue() {
        return cNewvalue;
    }

    public void setcNewvalue(String cNewvalue) {
        this.cNewvalue = cNewvalue;
    }

    @Basic
    @Column(name = "cBgr", nullable = true, length = 255)
    public String getcBgr() {
        return cBgr;
    }

    public void setcBgr(String cBgr) {
        this.cBgr = cBgr;
    }

    @Basic
    @Column(name = "cBgrxm", nullable = true, length = 255)
    public String getcBgrxm() {
        return cBgrxm;
    }

    public void setcBgrxm(String cBgrxm) {
        this.cBgrxm = cBgrxm;
    }

    @Basic
    @Column(name = "dBgsj", nullable = true)
    public Timestamp getdBgsj() {
        return dBgsj;
    }

    public void setdBgsj(Timestamp dBgsj) {
        this.dBgsj = dBgsj;
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
        PlateLog plateLog = (PlateLog) o;
        return Objects.equals(cCzrzbh, plateLog.cCzrzbh) &&
                Objects.equals(cTable, plateLog.cTable) &&
                Objects.equals(cTablekey, plateLog.cTablekey) &&
                Objects.equals(cKeyvalue, plateLog.cKeyvalue) &&
                Objects.equals(cColumn, plateLog.cColumn) &&
                Objects.equals(cColumnname, plateLog.cColumnname) &&
                Objects.equals(cCzfs, plateLog.cCzfs) &&
                Objects.equals(cOldvalue, plateLog.cOldvalue) &&
                Objects.equals(cNewvalue, plateLog.cNewvalue) &&
                Objects.equals(cBgr, plateLog.cBgr) &&
                Objects.equals(cBgrxm, plateLog.cBgrxm) &&
                Objects.equals(dBgsj, plateLog.dBgsj) &&
                Objects.equals(cCjuser, plateLog.cCjuser) &&
                Objects.equals(dCjsj, plateLog.dCjsj) &&
                Objects.equals(cXguser, plateLog.cXguser) &&
                Objects.equals(dXgsj, plateLog.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cCzrzbh, cTable, cTablekey, cKeyvalue, cColumn, cColumnname, cCzfs, cOldvalue, cNewvalue, cBgr, cBgrxm, dBgsj, cCjuser, dCjsj, cXguser, dXgsj);
    }

    @Override
    public String toString() {
        return "PlateLog{" +
                "cCzrzbh='" + cCzrzbh + '\'' +
                ", cTable='" + cTable + '\'' +
                ", cTablekey='" + cTablekey + '\'' +
                ", cKeyvalue='" + cKeyvalue + '\'' +
                ", cColumn='" + cColumn + '\'' +
                ", cColumnname='" + cColumnname + '\'' +
                ", cCzfs='" + cCzfs + '\'' +
                ", cOldvalue='" + cOldvalue + '\'' +
                ", cNewvalue='" + cNewvalue + '\'' +
                ", cBgr='" + cBgr + '\'' +
                ", cBgrxm='" + cBgrxm + '\'' +
                ", dBgsj=" + dBgsj +
                ", cCjuser='" + cCjuser + '\'' +
                ", dCjsj=" + dCjsj +
                ", cXguser='" + cXguser + '\'' +
                ", dXgsj=" + dXgsj +
                '}';
    }
}
