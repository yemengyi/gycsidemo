package com.gycsi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gycsi.pojo.*;
import com.gycsi.untils.Constants;
import com.gycsi.untils.HTTPClientUtils;
import com.gycsi.untils.WxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qian-pc on 7/14/16.
 */
public class CreateMenu {
    public static final Logger logger = LoggerFactory.getLogger(CreateMenu.class);

    public static void main(String[] args){
        createMenu();
    }

    public static int createMenu(){
        String url =" https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+AccessTokenService.getAccessToken();
        String json = getMenuJson();
        ObjectNode objectNode =
                HTTPClientUtils.sendHTTPRequest(url,json, RequestMethod.POST);
        int result =objectNode.get("errcode").asInt();
        if (result!=0) {
            System.out.println(result);
        }
        return result;
    }

    public static String getMenuJson(){

        ViewButton viewButton11 = new ViewButton();
        viewButton11.setName("生存认证");
        viewButton11.setType("view");
        viewButton11.setUrl(WxUtil.makeOauth2Url(Constants.oauth2_scrz));

        ComplexButton complexButton1 = new ComplexButton();
        complexButton1.setName("热门应用");
        complexButton1.setSub_button(new BaseButton[]{viewButton11});

//
//        ViewButton viewButton21 = new ViewButton();
//        viewButton21.setName("拍照上传");
//        viewButton21.setType("view");
//        viewButton21.setUrl("http://qianfeng.tunnel.qydev.com/wxjs_photo");

        ViewButton viewButton22 = new ViewButton();
        viewButton22.setName("身份绑定");
        viewButton22.setType("view");
        String url = WxUtil.makeOauth2Url(Constants.oauth2_sfyz);
        System.out.println(url);
        viewButton22.setUrl(url);

        ComplexButton complexButton2 = new ComplexButton();
        complexButton2.setName("个人中心");
        complexButton2.setSub_button(new BaseButton[]{viewButton22});

        CommonButton commonButton3 = new CommonButton();
        commonButton3.setName("社保动态");
        commonButton3.setType("click");
        commonButton3.setKey("3");


        Menu menu = new Menu();
        menu.setButton(new BaseButton[]{complexButton1,commonButton3,complexButton2});

        ObjectMapper mapper = new ObjectMapper();
        String json=null;
        try {
            json = mapper.writeValueAsString(menu);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
