package com.greenplatform.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PlateCodeDmzPK implements Serializable {
    private String cDmlb;
    private String cDm;

    @Column(name = "cDmlb", nullable = false, length = 255)
    @Id
    public String getcDmlb() {
        return cDmlb;
    }

    public void setcDmlb(String cDmlb) {
        this.cDmlb = cDmlb;
    }

    @Column(name = "cDm", nullable = false, length = 255)
    @Id
    public String getcDm() {
        return cDm;
    }

    public void setcDm(String cDm) {
        this.cDm = cDm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateCodeDmzPK that = (PlateCodeDmzPK) o;
        return Objects.equals(cDmlb, that.cDmlb) &&
                Objects.equals(cDm, that.cDm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cDmlb, cDm);
    }

    @Override
    public String toString() {
        return "PlateCodeDmzPK{" +
                "cDmlb='" + cDmlb + '\'' +
                ", cDm='" + cDm + '\'' +
                '}';
    }
}
