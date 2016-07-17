package com.gycsi.pojo;

/**
 * Created by qian-pc on 7/14/16.
 */
public class AccessToken {

    /**
     * access_token : ACCESS_TOKEN
     * expires_in : 7200
     */

    private String access_token;
    private long expires_in;
    private long expiresTime;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public long getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(long expiresTime) {
        this.expiresTime = expiresTime;
    }

    public boolean isExpires(){
        return System.currentTimeMillis()>expiresTime;
    }
}
