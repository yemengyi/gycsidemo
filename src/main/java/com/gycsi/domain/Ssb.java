package com.gycsi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by qiapc on 8/17/16.
 */
@Entity
@Table(name = "b_ssb")
public class Ssb implements Serializable{
    @Id
    private String ssbh;
    private String filename;
    private String sm;

    public String getSsbh() {
        return ssbh;
    }

    public void setSsbh(String ssbh) {
        this.ssbh = ssbh;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }
}
