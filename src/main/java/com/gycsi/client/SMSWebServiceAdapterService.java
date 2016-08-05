/**
 * SMSWebServiceAdapterService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gycsi.client;

public interface SMSWebServiceAdapterService extends javax.xml.rpc.Service {
    public java.lang.String getSMSWebServiceAdapterAddress();

    public com.gycsi.client.SMSWebServiceAdapter_PortType getSMSWebServiceAdapter() throws javax.xml.rpc.ServiceException;

    public com.gycsi.client.SMSWebServiceAdapter_PortType getSMSWebServiceAdapter(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
