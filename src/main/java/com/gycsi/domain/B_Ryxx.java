package com.gycsi.domain;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by qian-pc on 8/7/16.
 */
@Entity
@Table(name = "b_ryxx")
public class B_Ryxx {
    @EmbeddedId
    private Id id;
    private String xm;
    private String xb;
    private String sjhm;


    @Embeddable
    public static class Id implements Serializable {
        private String nd;
        private String sfzh;

        public Id(){

        }

        public Id(String nd,String sfzh){
            this.nd = nd;
            this.sfzh = sfzh;
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
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }
}
