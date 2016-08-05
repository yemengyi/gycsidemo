package com.gycsi.untils;

import com.gycsi.client.*;

/**
 * Created by qian-pc on 8/3/16.
 */
public class MasUtil {
    public static Boolean sendMsg(SMSReq smsReq) {
        Boolean rtn = false;
        try {
            SMSWebServiceAdapterService smsWebServiceAdapterService = new SMSWebServiceAdapterServiceLocator();
            SMSWebServiceAdapter_PortType stub = smsWebServiceAdapterService.getSMSWebServiceAdapter();
            SMSRes result = stub.sendSMS(smsReq);
            if (Integer.parseInt(result.getRtnCode())>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static SMSReq initSmsReq() {
        SMSReq smsReq = new SMSReq();
        smsReq.setApCode("gysb1");
        smsReq.setApPassword("gysb123!");
        smsReq.setAppId("");
        smsReq.setAppSeq("");
        smsReq.setAtTime("");
        smsReq.setDeliver("0");
        smsReq.setInspect("");
        smsReq.setLinkID("");
        smsReq.setPara_1("");
        smsReq.setPara_2("");
        smsReq.setPara_3("");
        smsReq.setPara_4("");
        smsReq.setPara_5("");
        smsReq.setReqFlag("");
        smsReq.setServiceId("");
        smsReq.setSndUID("gysb");
        smsReq.setSvr_flag("");
        smsReq.setTimeFlag("0");
        smsReq.setTitle("");
        smsReq.setUserFlag("1");
        smsReq.setWappush("0");
        return smsReq;
    }

}
