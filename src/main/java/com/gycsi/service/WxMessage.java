package com.gycsi.service;

import com.gycsi.domain.Gary;
import com.gycsi.message.TextMessage;
import com.gycsi.untils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by qian-pc on 7/13/16.
 */
@Service
public class WxMessage {
    @Autowired
    GaryService garyService;

    public String processMessage(HttpServletRequest request) {
        String respWxMessage = "";

        try {
            Map<String, String> messageMap = MessageUtil.parseXml(request);
            String toUserName = messageMap.get("ToUserName");
            String fromUserName = messageMap.get("FromUserName");
            String msgType = messageMap.get("MsgType");

            switch (msgType) {
                case MessageUtil.REQ_MESSAGE_TYPE_TEXT:
                    String content = messageMap.get("Content");
                    String respContent = "";
                    if (content.length() == 18) {
                        Gary gary = garyService.getGaryBySfzh(content);
                        if (gary != null) {
                            respContent = gary.getWxInfo();
                        }
                    } else {
                        respContent = "欢迎使用社保服务。";
                    }
                    TextMessage respMessage = new TextMessage();
                    respMessage.setFromUserName(toUserName);
                    respMessage.setToUserName(fromUserName);
                    respMessage.setCreateTime(new Date().getTime());
                    respMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
                    respMessage.setContent(respContent);
                    respWxMessage = MessageUtil.textMessageToXml(respMessage);
                    break;
                case MessageUtil.REQ_MESSAGE_TYPE_EVENT:
                    String event = messageMap.get("Event");
                    if (event.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                        TextMessage respMessage2 = new TextMessage();
                        respMessage2.setFromUserName(toUserName);
                        respMessage2.setToUserName(fromUserName);
                        respMessage2.setCreateTime(new Date().getTime());
                        respMessage2.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
                        respMessage2.setContent("欢迎订阅");
                        respWxMessage = MessageUtil.textMessageToXml(respMessage2);
                    }
                    break;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return respWxMessage;

    }
}
