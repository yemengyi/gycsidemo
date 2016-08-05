package com.gycsi.service;

import com.gycsi.untils.Constants;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

/**
 * Created by qian-pc on 8/4/16.
 */
public class Oauth2 {

    public static void main(String args[]){
        makeUrl();
    }

    public static void makeUrl() {
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId(Constants.appid);
        config.setSecret(Constants.appsecret);
        config.setToken(Constants.token);
        config.setAesKey("");

        WxMpServiceImpl wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);


       String url =  wxService.oauth2buildAuthorizationUrl(WxConsts.OAUTH2_SCOPE_USER_INFO, null);

        System.out.println("   xxxxx    " + url);
    }

}
