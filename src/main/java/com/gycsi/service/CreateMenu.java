package com.gycsi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gycsi.pojo.*;
import com.gycsi.untils.HTTPClientUtils;
import com.gycsi.untils.WxUtil;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qian-pc on 7/14/16.
 */
public class CreateMenu {

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

        CommonButton commonButton11 = new CommonButton();
        commonButton11.setName("菜单11");
        commonButton11.setType("click");
        commonButton11.setKey("11");

        CommonButton commonButton12 = new CommonButton();
        commonButton12.setName("菜单12");
        commonButton12.setType("click");
        commonButton12.setKey("12");

        ComplexButton complexButton1 = new ComplexButton();
        complexButton1.setName("菜单1");
        complexButton1.setSub_button(new BaseButton[]{commonButton11,commonButton12});

        ViewButton viewButton21 = new ViewButton();
        viewButton21.setName("拍照上传");
        viewButton21.setType("view");
        viewButton21.setUrl("http://qianfeng.tunnel.qydev.com/wxjs_photo");

        ViewButton viewButton22 = new ViewButton();
        viewButton22.setName("Oathu2");
        viewButton22.setType("view");
        String url = WxUtil.makeOauth2Url();

        viewButton22.setUrl(url);

        ComplexButton complexButton2 = new ComplexButton();
        complexButton2.setName("菜单2");
        complexButton2.setSub_button(new BaseButton[]{viewButton21,viewButton22});

        Menu menu = new Menu();
        menu.setButton(new BaseButton[]{complexButton1,complexButton2});

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
