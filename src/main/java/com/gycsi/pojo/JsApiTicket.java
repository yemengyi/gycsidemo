package com.gycsi.pojo;

/**
 * Created by edwardlu on 2016/7/2.
 */
public class JsApiTicket {
    // 获取到的凭证
    private String JsApiTicket;
    // 凭证有效时间，单位：秒
    private long expiresTime;

    public String getJsApiTicket() {
        return JsApiTicket;
    }

    public void setJsApiTicket(String jsApiTicket) {
        JsApiTicket = jsApiTicket;
    }

    public long getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(long expiresTime) {
        this.expiresTime = expiresTime;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.expiresTime;
    }
}
