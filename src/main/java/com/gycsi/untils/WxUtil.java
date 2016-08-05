package com.gycsi.untils;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

/**
 * Created by qian-pc on 8/5/16.
 */
public class WxUtil {

    public static WxMpServiceImpl wxMpService;

    public static void initWx(){
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId(Constants.appid);
        config.setSecret(Constants.appsecret);
        config.setToken(Constants.token);
        config.setAesKey("");
        WxMpServiceImpl wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);
        wxMpService = wxService;
    }


    public static String makeOauth2Url() {
        initWx();
        String url =  wxMpService.oauth2buildAuthorizationUrl(Constants.oauth2,WxConsts.OAUTH2_SCOPE_BASE, null);
        return url;
    }
}
