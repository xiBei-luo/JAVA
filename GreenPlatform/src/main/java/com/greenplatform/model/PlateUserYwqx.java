package com.greenplatform.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "plate_user_ywqx", schema = "greenplatform", catalog = "")
public class PlateUserYwqx {
    private String cUserid;
    private String cYwlxdm;
    private String cSquser;
    private String cCjuser;
    private Timestamp dCjsj;
    private String cXguser;
    private Timestamp dXgsj;

    @Basic
    @Column(name = "cUserid", nullable = false, length = 11)
    public String getcUserid() {
        return cUserid;
    }

    public void setcUserid(String cUserid) {
        this.cUserid = cUserid;
    }

    @Basic
    @Column(name = "cYwlxdm", nullable = true, length = 255)
    public String getcYwlxdm() {
        return cYwlxdm;
    }

    public void setcYwlxdm(String cYwlxdm) {
        this.cYwlxdm = cYwlxdm;
    }

    @Basic
    @Column(name = "cSquser", nullable = true, length = 11)
    public String getcSquser() {
        return cSquser;
    }

    public void setcSquser(String cSquser) {
        this.cSquser = cSquser;
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
        PlateUserYwqx that = (PlateUserYwqx) o;
        return Objects.equals(cUserid, that.cUserid) &&
                Objects.equals(cYwlxdm, that.cYwlxdm) &&
                Objects.equals(cSquser, that.cSquser) &&
                Objects.equals(cCjuser, that.cCjuser) &&
                Objects.equals(dCjsj, that.dCjsj) &&
                Objects.equals(cXguser, that.cXguser) &&
                Objects.equals(dXgsj, that.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cUserid, cYwlxdm, cSquser, cCjuser, dCjsj, cXguser, dXgsj);
    }

    @Override
    public String toString() {
        return "PlateUserYwqx{" +
                "cUserid='" + cUserid + '\'' +
                ", cYwlxdm='" + cYwlxdm + '\'' +
                ", cSquser='" + cSquser + '\'' +
                ", cCjuser='" + cCjuser + '\'' +
                ", dCjsj=" + dCjsj +
                ", cXguser='" + cXguser + '\'' +
                ", dXgsj=" + dXgsj +
                '}';
    }
}
