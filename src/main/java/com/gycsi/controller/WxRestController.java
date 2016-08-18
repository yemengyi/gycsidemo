package com.gycsi.controller;

import com.gycsi.dao.BdxxDao;
import com.gycsi.dao.MasDao;
import com.gycsi.dao.SfyzDao;
import com.gycsi.domain.B_Ryxx;
import com.gycsi.service.AccessTokenService;
import com.gycsi.service.WxMessage;
import com.gycsi.untils.Constants;
import com.gycsi.untils.HTTPClientUtils;
import com.gycsi.untils.MasUtil;
import com.gycsi.untils.SignUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Map;

/**
 * Created by qian-pc on 8/8/16.
 */
@RestController
public class WxRestController {
    @Autowired
    WxMessage wxMessage;
    @Autowired
    SfyzDao sfyzDao;
    @Autowired
    MasDao masDao;
    @Autowired
    BdxxDao bdxxDao;


    @RequestMapping("/")
    String hello() {
        return "hello sping boot";
    }

    @RequestMapping(value = Constants.url, method = RequestMethod.GET)
    String checkWx(@RequestParam String signature,
                   @RequestParam String timestamp,
                   @RequestParam String nonce,
                   @RequestParam String echostr) {

        if (SignUtils.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return "";
    }

    //接收微信信息
    @RequestMapping(value = Constants.url, method = RequestMethod.POST)
    String messageProcess(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String respMessage = wxMessage.processMessage(request);
        return respMessage;
    }

    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    Map<String, String> sign(@RequestBody Map<String, String> params) throws ServletException, IOException {
        String url = params.get("url");
        String jsApiTicket = AccessTokenService.getJsApiTicket();
        return SignUtils.sign(jsApiTicket, url);
    }

    @RequestMapping(value = "/sfyz", method = RequestMethod.POST)
    Map<String, String> sfyz(@RequestBody Map<String, String> params) {

        //人员信息验证
        B_Ryxx b_ryxx = sfyzDao.findByNdAndSfzh(Constants.ND, params.get("sfzh").toUpperCase());
        if (b_ryxx != null) {
            if (!b_ryxx.getXm().equals(params.get("xm"))) {
                params.put("code", "error");
                params.put("result", Constants.no_xm);
            } else if (b_ryxx.getSjhm() == null) {
                params.put("code", "error");
                params.put("result", Constants.no_sjhm);
            } else {
                params.put("code", "success");
                params.put("sjhm", b_ryxx.getSjhm());
            }
        } else {
            params.put("code", "error");
            params.put("result", Constants.no_ryxx);
        }
        return params;
    }

    @RequestMapping("/mass")
    String send_mas(@RequestParam String sjhm) {
        String yzm = MasUtil.makeRandom();
        String content = "您此次的验证码为:" + yzm;
        MasUtil.sendMsg(sjhm, content);
        //写入数据库
        masDao.saveMas(sjhm, yzm, "0");
        return "{'code':'success'}";
    }

    @RequestMapping(value = "/dxyz", method = RequestMethod.POST)
    Map<String, String> dxyz(@RequestBody Map<String, String> params) {
        //短信验证
        String sfzh = params.get("sfzh");
        String xm = params.get("xm");
        String sjhm = params.get("sjhm");
        String yzm = params.get("dx");
        String openid = params.get("openid");
        //检测是否有已存在的绑定信息
        if (bdxxDao.findByOpenid(openid, "1") != null) {
            params.put("code", "error");
            params.put("result", "该微信号已经存在绑定人员信息,不能重复绑定!");
            return params;
        }
        ;
        if (masDao.checkYZM(sjhm, yzm)) {
            //成功后绑定
            if (bdxxDao.saveBdxx(sfzh, xm, openid, "1", sjhm)) {
                params.put("code", "success");
            } else {
                params.put("code", "error");
                params.put("result", "绑定信息失败!");
            }
        } else {
            //提示错误
            params.put("code", "error");
            params.put("result", "验证码不正确,请从新输入!");
        }
        return params;
    }


    @RequestMapping("/jbbdxx")
    String reset_bdxx(@RequestParam String openid) {
        Boolean aBoolean = bdxxDao.resetBdxx(openid);
        if (aBoolean) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    String uploadImage(@RequestBody Map<String, String> params) throws Exception {
        String serverId = params.get("serverId").toString();
        String url = "http://file.api.weixin.qq.com/cgi-bin/media/get"
                + "?access_token=" + AccessTokenService.getAccessToken()
                + "&media_id=" + serverId;
        URL imageURL = new URL(url);
        String fileName = "image//" + System.currentTimeMillis() + ".jpg";
        HTTPClientUtils.downLoadFile(imageURL, new File(fileName));
        return "success";
    }


}
