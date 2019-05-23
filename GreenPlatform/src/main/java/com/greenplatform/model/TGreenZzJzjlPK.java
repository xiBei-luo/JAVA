package com.greenplatform.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TGreenZzJzjlPK implements Serializable {
    private String cLsh;
    private String cZzzjlsh;

    @Column(name = "cLsh", nullable = false, length = 255)
    @Id
    public String getcLsh() {
        return cLsh;
    }

    public void setcLsh(String cLsh) {
        this.cLsh = cLsh;
    }

    @Column(name = "cZzzjlsh", nullable = false, length = 255)
    @Id
    public String getcZzzjlsh() {
        return cZzzjlsh;
    }

    public void setcZzzjlsh(String cZzzjlsh) {
        this.cZzzjlsh = cZzzjlsh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TGreenZzJzjlPK that = (TGreenZzJzjlPK) o;
        return Objects.equals(cLsh, that.cLsh) &&
                Objects.equals(cZzzjlsh, that.cZzzjlsh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cLsh, cZzzjlsh);
    }
}
