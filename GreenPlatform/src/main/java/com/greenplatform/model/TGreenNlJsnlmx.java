package com.greenplatform.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_green_nl_jsnlmx", schema = "greenplatform", catalog = "")
public class TGreenNlJsnlmx {
    private String cLsh;
    private String cUserid;
    private String cJssl;
    private Timestamp dJssj;
    private String cJsyy;
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
    @Column(name = "cJssl", nullable = true, length = 255)
    public String getcJssl() {
        return cJssl;
    }

    public void setcJssl(String cJssl) {
        this.cJssl = cJssl;
    }

    @Basic
    @Column(name = "dJssj", nullable = true)
    public Timestamp getdJssj() {
        return dJssj;
    }

    public void setdJssj(Timestamp dJssj) {
        this.dJssj = dJssj;
    }

    @Basic
    @Column(name = "cJsyy", nullable = true, length = 255)
    public String getcJsyy() {
        return cJsyy;
    }

    public void setcJsyy(String cJsyy) {
        this.cJsyy = cJsyy;
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
        TGreenNlJsnlmx that = (TGreenNlJsnlmx) o;
        return Objects.equals(cLsh, that.cLsh) &&
                Objects.equals(cUserid, that.cUserid) &&
                Objects.equals(cJssl, that.cJssl) &&
                Objects.equals(dJssj, that.dJssj) &&
                Objects.equals(cJsyy, that.cJsyy) &&
                Objects.equals(cBz, that.cBz) &&
                Objects.equals(cZt, that.cZt) &&
                Objects.equals(cCjuser, that.cCjuser) &&
                Objects.equals(dCjsj, that.dCjsj) &&
                Objects.equals(cXguser, that.cXguser) &&
                Objects.equals(dXgsj, that.dXgsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cLsh, cUserid, cJssl, dJssj, cJsyy, cBz, cZt, cCjuser, dCjsj, cXguser, dXgsj);
    }
}
