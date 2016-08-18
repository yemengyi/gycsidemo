package com.gycsi.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gycsi.pojo.AccessToken;
import com.gycsi.pojo.JsApiTicket;
import com.gycsi.untils.Constants;
import com.gycsi.untils.HTTPClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qian-pc on 7/14/16.
 */
public class AccessTokenService {
    private static final Logger logger = LoggerFactory.getLogger(AccessTokenService.class);
    private static AccessToken accessToken = new AccessToken();
    private static JsApiTicket jsApiTicket = new JsApiTicket();

    public static void main(String[] args){
        logger.info(getAccessToken());
    }

    public static String getAccessToken(){
        if (accessToken.isExpires()) {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+
                    Constants.appid+"&secret="+Constants.appsecret;

            ObjectNode objectNode = HTTPClientUtils.sendHTTPRequest(url,null, RequestMethod.GET);
            String token = objectNode.get("access_token").asText();
            long expires_in = objectNode.get("expires_in").asLong();
            long expiresTime = System.currentTimeMillis() + (expires_in - 200) * 1000;

            accessToken.setAccess_token(token);
            accessToken.setExpires_in(expires_in);
            accessToken.setExpiresTime(expiresTime);
        }
        return accessToken.getAccess_token();
    }

    public static String getJsApiTicket() {
        if (jsApiTicket.isExpired()) {
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi"
                    + "&access_token=" + getAccessToken();
            try {
                ObjectNode objectNode = HTTPClientUtils.sendHTTPRequest(url, null,RequestMethod.GET);
                jsApiTicket.setJsApiTicket(objectNode.get("ticket").asText());
                long expireTime = System.currentTimeMillis() + (objectNode.get("expires_in").asLong() - 200) * 1000l;
                jsApiTicket.setExpiresTime(expireTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return jsApiTicket.getJsApiTicket();
    }

}
