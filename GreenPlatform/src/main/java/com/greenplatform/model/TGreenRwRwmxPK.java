package com.greenplatform.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TGreenRwRwmxPK implements Serializable {
    private String cUserid;
    private String cRwlb;
    private String cRwsj;

    @Column(name = "cUserid", nullable = false, length = 255)
    @Id
    public String getcUserid() {
        return cUserid;
    }

    public void setcUserid(String cUserid) {
        this.cUserid = cUserid;
    }

    @Column(name = "cRwlb", nullable = false, length = 1)
    @Id
    public String getcRwlb() {
        return cRwlb;
    }

    public void setcRwlb(String cRwlb) {
        this.cRwlb = cRwlb;
    }

    @Column(name = "cRwsj", nullable = false, length = 255)
    @Id
    public String getcRwsj() {
        return cRwsj;
    }

    public void setcRwsj(String cRwsj) {
        this.cRwsj = cRwsj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TGreenRwRwmxPK that = (TGreenRwRwmxPK) o;
        return Objects.equals(cUserid, that.cUserid) &&
                Objects.equals(cRwlb, that.cRwlb) &&
                Objects.equals(cRwsj, that.cRwsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cUserid, cRwlb, cRwsj);
    }
}
