package com.gycsi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by qian-pc on 8/8/16.
 */
@Entity
@Table(name = "c_mas")
public class C_Mas {
    @Id
    private long xh;
    private String sjhm;
    private String yzm;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fssj;
    private String yxbz;

    public C_Mas(){

    };

    public C_Mas(String sjhm, String yzm, String yxbz){
        this.sjhm = sjhm;
        this.yzm = yzm;
        this.fssj = new Date();
        this.yxbz = yxbz;
    };

    public long getXh() {
        return xh;
    }

    public void setXh(long xh) {
        this.xh = xh;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    public Date getFfsj() {
        return fssj;
    }

    public void setFfsj(Date ffsj) {
        this.fssj = ffsj;
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }
}
