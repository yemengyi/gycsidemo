/**
 * SMSWebServiceAdapter_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gycsi.client;

public interface SMSWebServiceAdapter_PortType extends java.rmi.Remote {
    public void main(java.lang.String[] args) throws java.rmi.RemoteException;
    public com.gycsi.client.SMSRes sendSMS(com.gycsi.client.SMSReq req) throws java.rmi.RemoteException;
    public com.gycsi.client.SMSMsg[] getReceivedSms(java.lang.String applicationID, java.lang.String appPwd) throws java.rmi.RemoteException;
    public com.gycsi.client.SMSDeliveryStatus[] getSmsDeliveryStatus(java.lang.String msg_id, java.lang.String appPwd) throws java.rmi.RemoteException;
    public com.gycsi.client.SMSParam getSMSParam(java.lang.String SMSPWD) throws java.rmi.RemoteException;
}
