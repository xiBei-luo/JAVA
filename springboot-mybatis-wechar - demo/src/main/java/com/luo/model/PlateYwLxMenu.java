package com.luo.model;


public class PlateYwLxMenu {

  private String cYwlxdm;
  private String cMenudm;
  private String cMenumc;
  private String cZt;
  private String cBz;
  private String cCjuser;
  private java.sql.Timestamp dCjsj;
  private String cXjuser;
  private java.sql.Timestamp dXgsj;


  public String getCYwlxdm() {
    return cYwlxdm;
  }

  public void setCYwlxdm(String cYwlxdm) {
    this.cYwlxdm = cYwlxdm;
  }


  public String getCMenudm() {
    return cMenudm;
  }

  public void setCMenudm(String cMenudm) {
    this.cMenudm = cMenudm;
  }


  public String getCMenumc() {
    return cMenumc;
  }

  public void setCMenumc(String cMenumc) {
    this.cMenumc = cMenumc;
  }


  public String getCZt() {
    return cZt;
  }

  public void setCZt(String cZt) {
    this.cZt = cZt;
  }


  public String getCBz() {
    return cBz;
  }

  public void setCBz(String cBz) {
    this.cBz = cBz;
  }


  public String getCCjuser() {
    return cCjuser;
  }

  public void setCCjuser(String cCjuser) {
    this.cCjuser = cCjuser;
  }


  public java.sql.Timestamp getDCjsj() {
    return dCjsj;
  }

  public void setDCjsj(java.sql.Timestamp dCjsj) {
    this.dCjsj = dCjsj;
  }


  public String getCXjuser() {
    return cXjuser;
  }

  public void setCXjuser(String cXjuser) {
    this.cXjuser = cXjuser;
  }


  public java.sql.Timestamp getDXgsj() {
    return dXgsj;
  }

  public void setDXgsj(java.sql.Timestamp dXgsj) {
    this.dXgsj = dXgsj;
  }

  @Override
  public String toString() {
    return "PlateYwLxMenu{" +
            "cYwlxdm='" + cYwlxdm + '\'' +
            ", cMenudm='" + cMenudm + '\'' +
            ", cMenumc='" + cMenumc + '\'' +
            ", cZt='" + cZt + '\'' +
            ", cBz='" + cBz + '\'' +
            ", cCjuser='" + cCjuser + '\'' +
            ", dCjsj=" + dCjsj +
            ", cXjuser='" + cXjuser + '\'' +
            ", dXgsj=" + dXgsj +
            '}';
  }
}
