/**
 * SMSWebServiceAdapterServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gycsi.client;

public class SMSWebServiceAdapterServiceLocator extends org.apache.axis.client.Service implements com.gycsi.client.SMSWebServiceAdapterService {

    public SMSWebServiceAdapterServiceLocator() {
    }


    public SMSWebServiceAdapterServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SMSWebServiceAdapterServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SMSWebServiceAdapter
    private java.lang.String SMSWebServiceAdapter_address = "http://172.20.1.14:88/mas1/services/SMSWebServiceAdapter";

    public java.lang.String getSMSWebServiceAdapterAddress() {
        return SMSWebServiceAdapter_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SMSWebServiceAdapterWSDDServiceName = "SMSWebServiceAdapter";

    public java.lang.String getSMSWebServiceAdapterWSDDServiceName() {
        return SMSWebServiceAdapterWSDDServiceName;
    }

    public void setSMSWebServiceAdapterWSDDServiceName(java.lang.String name) {
        SMSWebServiceAdapterWSDDServiceName = name;
    }

    public com.gycsi.client.SMSWebServiceAdapter_PortType getSMSWebServiceAdapter() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SMSWebServiceAdapter_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSMSWebServiceAdapter(endpoint);
    }

    public com.gycsi.client.SMSWebServiceAdapter_PortType getSMSWebServiceAdapter(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gycsi.client.SMSWebServiceAdapterSoapBindingStub _stub = new com.gycsi.client.SMSWebServiceAdapterSoapBindingStub(portAddress, this);
            _stub.setPortName(getSMSWebServiceAdapterWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSMSWebServiceAdapterEndpointAddress(java.lang.String address) {
        SMSWebServiceAdapter_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gycsi.client.SMSWebServiceAdapter_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gycsi.client.SMSWebServiceAdapterSoapBindingStub _stub = new com.gycsi.client.SMSWebServiceAdapterSoapBindingStub(new java.net.URL(SMSWebServiceAdapter_address), this);
                _stub.setPortName(getSMSWebServiceAdapterWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SMSWebServiceAdapter".equals(inputPortName)) {
            return getSMSWebServiceAdapter();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://172.20.1.14:88/mas1/services/SMSWebServiceAdapter", "SMSWebServiceAdapterService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://172.20.1.14:88/mas1/services/SMSWebServiceAdapter", "SMSWebServiceAdapter"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SMSWebServiceAdapter".equals(portName)) {
            setSMSWebServiceAdapterEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
