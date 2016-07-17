package com.gycsi.domain;


import javax.persistence.*;

/**
 * Created by qian-pc on 7/12/16.
 */
@Entity
@Table(name = "v_b")
public class Gary {
    @Id
    @Column(name="SFZH")
    private String sfzh;
    private String xm;
    private String hid;
    private String jtgx;
    private String dz;
    @Transient
    private String fileName;

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getJtgx() {
        return jtgx;
    }

    public void setJtgx(String jtgx) {
        this.jtgx = jtgx;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }


    public String getWxInfo(){
        return sfzh + " " + xm + " " + dz;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
