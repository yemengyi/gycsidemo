package com.gycsi.untils;

import com.gycsi.service.AccessTokenService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by qian-pc on 8/5/16.
 */
public class WxUtil {

    public static WxMpServiceImpl wxMpService;
    private static final Logger logger = LoggerFactory.getLogger(AccessTokenService.class);


    static
    {
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId(Constants.appid);
        config.setSecret(Constants.appsecret);
        config.setToken(Constants.token);
        config.setAesKey(Constants.aesKey);
        WxMpServiceImpl wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);
        wxMpService = wxService;
    }


    public static String makeOauth2Url(String state) {
        String url =  wxMpService.oauth2buildAuthorizationUrl(Constants.oauth2_URL,WxConsts.OAUTH2_SCOPE_BASE,state);
        logger.debug("wxUtil - makeOauth2Url",url);
        return url;
    }

    public static String getOpenId(String code){
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            return wxMpOAuth2AccessToken.getOpenId();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "";
    }

}
