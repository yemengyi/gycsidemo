package com.gycsi.controller;

import com.gycsi.service.AccessTokenService;
import com.gycsi.service.WxMessage;
import com.gycsi.untils.Constants;
import com.gycsi.untils.HTTPClientUtils;
import com.gycsi.untils.SignUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * Created by qian-pc on 7/13/16.
 */
@Controller
public class WxController {
    private static final Logger logger = LoggerFactory.getLogger(AccessTokenService.class);

    @Autowired
    WxMessage wxMessage;


    @RequestMapping(value = Constants.url,method = RequestMethod.GET)
    @ResponseBody
    String checkWx(@RequestParam String signature,
                   @RequestParam String timestamp,
                   @RequestParam String nonce,
                   @RequestParam String echostr){

        if (SignUtils.checkSignature(signature,timestamp,nonce)) {
            return echostr;
        }
        return "";
    }


    //接收微信信息
//    @RequestMapping(value = Constants.url,method = RequestMethod.POST)
//    @ResponseBody
//    String messageProcess(HttpServletRequest request){
//        try {
//            request.setCharacterEncoding("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        String respMessage = wxMessage.processMessage(request);
//        return respMessage;
//    }

    @RequestMapping("/wxjs_photo")
    String wxjs_photo() {
        return "wxjs_photo";
    }

    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    @ResponseBody
    Map<String, String> sign(@RequestBody Map<String, String> params) throws ServletException, IOException {
        String url = params.get("url");
        String jsApiTicket = AccessTokenService.getJsApiTicket();
        return SignUtils.sign(jsApiTicket, url);
    }

    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    @ResponseBody
    String uploadImage(@RequestBody Map<String, String> params) throws Exception{
        String serverId = params.get("serverId").toString();

//        log.info("image server id:" + serverId);

        String url = "http://file.api.weixin.qq.com/cgi-bin/media/get"
                + "?access_token=" + AccessTokenService.getAccessToken()
                + "&media_id=" + serverId;

        URL imageURL = new URL(url);
        String fileName = "image//"+ System.currentTimeMillis() + ".jpg";

        HTTPClientUtils.downLoadFile(imageURL, new File(fileName));

        return "success";
    }

}
