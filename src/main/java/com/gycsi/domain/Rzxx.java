package com.gycsi.domain;



import javax.persistence.*;
import java.util.Date;

/**
 * Created by qian-pc on 8/14/16.
 */
@Entity
@Table(name = "c_rzxx")
public class Rzxx {
    @Id
    private long xh;
    private String nd;
    private String sfzh;
    private String xm;
    private String ssbh;
    @Temporal(TemporalType.TIMESTAMP)
    private Date rzsj;
    private String yxbz;
    private String bz;
    private String zp_url;
    @Temporal(TemporalType.TIMESTAMP)
    private Date zpsj;
    @Temporal(TemporalType.TIMESTAMP)
    private Date cjsj;
    @OneToOne(targetEntity = Ssb.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ssbh",insertable = false,updatable = false)
    private Ssb ssb;

    public Rzxx() {
    };

    public Rzxx(String nd, String sfzh, String xm, String ssbh, String yxbz) {
        this.nd = nd;
        this.sfzh = sfzh;
        this.xm = xm;
        this.ssbh = ssbh;
        this.yxbz = yxbz;
        this.cjsj = new Date();
    };


    public Ssb getSsb() {
        return ssb;
    }

    public void setSsb(Ssb ssb) {
        this.ssb = ssb;
    }

    public long getXh() {
        return xh;
    }

    public void setXh(long xh) {
        this.xh = xh;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
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

    public String getSsbh() {
        return ssbh;
    }

    public void setSsbh(String ssbh) {
        this.ssbh = ssbh;
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getZp_url() {
        return zp_url;
    }

    public void setZp_url(String zp_url) {
        this.zp_url = zp_url;
    }

    public Date getZpsj() {
        return zpsj;
    }

    public void setZpsj(Date zpsj) {
        this.zpsj = zpsj;
    }

    public Date getRzsj() {
        return rzsj;
    }

    public void setRzsj(Date rzsj) {
        this.rzsj = rzsj;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }
}
