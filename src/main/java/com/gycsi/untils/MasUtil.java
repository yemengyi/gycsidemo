package com.gycsi.untils;

import com.gycsi.client.*;

import java.util.Random;

/**
 * Created by qian-pc on 8/3/16.
 */
public class MasUtil {
    public static Boolean sendMsg(String destNumber,String content) {
        SMSReq smsReq = initSmsReq();
        smsReq.setMsgContent(content);
        smsReq.setDestNumber(destNumber);
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

    public static String makeRandom(){
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for(int i = 0; i < 6; i++)
            result = result * 10 + array[i];
        String yzm = String.valueOf(result);
        if (yzm.length()==5) {
            yzm = yzm + "0";
        }
       return yzm;
    }

    public static String makeSSRandom(){
        return String.valueOf((int)(Math.random()*32+1));
    }

}
