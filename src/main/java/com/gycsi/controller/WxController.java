package com.gycsi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gycsi.dao.BdxxDao;
import com.gycsi.dao.RzxxDao;
import com.gycsi.domain.Bdxx;
import com.gycsi.domain.Rzxx;
import com.gycsi.domain.Ssb;
import com.gycsi.repository.SsbRepository;
import com.gycsi.service.AccessTokenService;
import com.gycsi.untils.Constants;
import com.gycsi.untils.MasUtil;
import com.gycsi.untils.WxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by qian-pc on 7/13/16.
 */
@Controller
public class WxController {
    private static final Logger logger = LoggerFactory.getLogger(AccessTokenService.class);
    @Autowired
    BdxxDao bdxxDao;
    @Autowired
    RzxxDao rzxxDao;
    @Autowired
    SsbRepository ssbRepository;

    @RequestMapping("/wxjs_photo")
    String wxjs_photo() {
        return "wxjs_photo";
    }

    @RequestMapping("/oauth2")
    String sfyz(@RequestParam String code, @RequestParam String state, Model model) throws JsonProcessingException {
        if (code==null) {
            model.addAttribute("result", "网页超时,请稍后再试!");
            return "error_page";
        }
        String openId = WxUtil.getOpenId(code);
        model.addAttribute("openid", openId);
        model.addAttribute("ss_url",Constants.ss_url);
        //判断是否绑定
        Bdxx bdxx = bdxxDao.findByOpenid(openId, "1");
        switch (state) {
            case Constants.oauth2_sfyz:
                if (bdxx == null) {
                    return "oauth2/" + state;
                } else {
                    model.addAttribute(bdxx);
                    return "oauth2/bdxx";
                }
            case Constants.oauth2_scrz:
                if (bdxx == null) { //未绑定
                    model.addAttribute("result", "请先绑定人员信息!");
                    model.addAttribute("url", WxUtil.makeOauth2Url(Constants.oauth2_sfyz));
                    model.addAttribute("info", "身份绑定");
                    return "error_page";
                } else {
                    //判断验证信息状态
                    Rzxx rzxx = rzxxDao.findRzxx(Constants.ND, bdxx.getSfzh());
                    if (rzxx == null) { //没有认证信息
                        String ss = MasUtil.makeSSRandom();
                        Rzxx new_rzxx = rzxxDao.addRzxx(Constants.ND, bdxx.getSfzh(), "0", ss, bdxx.getXm());
                        if (new_rzxx==null) {
                            model.addAttribute("result", "保存数据出错!");
                            return "error_page";
                        }else {
                            rzxx = new_rzxx;
                        }
                        Ssb ssb = ssbRepository.findBySsbh(ss);
                        rzxx.setSsb(ssb);
                        model.addAttribute(rzxx);
                        return "scrz/step1";
                    } else {  //已有认证信息
                        model.addAttribute(rzxx);
                        switch (rzxx.getYxbz()) {
                            case "0": //未上传照片
                                return "scrz/step1";
                            case "1": //已通过
                                return "scrz/rzxx";
                            case "2": //未通过
                                return "scrz/rzxx";
                            case "3": //已上传未审批
                                return "scrz/rzxx";
                        }
                    }
                }
        }
        return null;
    }

    @RequestMapping("/sfbd")
    String sfbd(@RequestParam String openid, @RequestParam String sfzh, @RequestParam String sjhm, @RequestParam String xm, Model model) {
        model.addAttribute("openid", openid);
        model.addAttribute("sfzh", sfzh);
        model.addAttribute("sjhm", sjhm);
        model.addAttribute("xm", xm);
        return "oauth2/sfbd";
    }

    @RequestMapping("/error_page")
    String error_page(@RequestParam String result, Model model) {
        model.addAttribute("result", result);
        return "error_page";
    }

    @RequestMapping("/show_bdxx")
    String bdxx(@RequestParam String openid, Model model) {
        Bdxx bdxx = bdxxDao.findByOpenid(openid, "1");
        model.addAttribute("openid", openid);
        model.addAttribute(bdxx);
        return "oauth2/bdxx";
    }

    @RequestMapping("/step2")
    String scrz(@RequestParam long xh,Model model){
        model.addAttribute("xh",xh);
        return "scrz/step2";
    }

}
