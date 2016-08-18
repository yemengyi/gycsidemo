package com.gycsi.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by qian-pc on 8/9/16.
 */
@Entity
@Table(name = "c_bdxx")
public class Bdxx {
    @Id
    private long xh;
    private String sfzh;
    private String xm;
    private String openid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date bdsj;
    @Temporal(TemporalType.TIMESTAMP)
    private Date jbsj;
    private String yxbz ;
    private String sjhm;

    public Bdxx(){}

    public Bdxx(String sfzh,String xm,String openid,String yxbz,String sjhm){
        this.sfzh = sfzh;
        this.xm = xm;
        this.openid = openid;
        this.yxbz = yxbz;
        this.bdsj = new Date();
        this.sjhm = sjhm;
    }

    public long getXh() {
        return xh;
    }

    public void setXh(long xh) {
        this.xh = xh;
    }

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Date getBdsj() {
        return bdsj;
    }

    public void setBdsj(Date bdsj) {
        this.bdsj = bdsj;
    }

    public Date getJbsj() {
        return jbsj;
    }

    public void setJbsj(Date jbsj) {
        this.jbsj = jbsj;
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }
}
