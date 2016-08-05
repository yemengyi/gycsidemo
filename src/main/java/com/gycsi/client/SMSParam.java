/**
 * SMSParam.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gycsi.client;

public class SMSParam  implements java.io.Serializable {
    private java.lang.String SMS_QUNFA_APPID;

    private java.lang.String SMS_QUNFA_EXTCODE;

    public SMSParam() {
    }

    public SMSParam(
           java.lang.String SMS_QUNFA_APPID,
           java.lang.String SMS_QUNFA_EXTCODE) {
           this.SMS_QUNFA_APPID = SMS_QUNFA_APPID;
           this.SMS_QUNFA_EXTCODE = SMS_QUNFA_EXTCODE;
    }


    /**
     * Gets the SMS_QUNFA_APPID value for this SMSParam.
     * 
     * @return SMS_QUNFA_APPID
     */
    public java.lang.String getSMS_QUNFA_APPID() {
        return SMS_QUNFA_APPID;
    }


    /**
     * Sets the SMS_QUNFA_APPID value for this SMSParam.
     * 
     * @param SMS_QUNFA_APPID
     */
    public void setSMS_QUNFA_APPID(java.lang.String SMS_QUNFA_APPID) {
        this.SMS_QUNFA_APPID = SMS_QUNFA_APPID;
    }


    /**
     * Gets the SMS_QUNFA_EXTCODE value for this SMSParam.
     * 
     * @return SMS_QUNFA_EXTCODE
     */
    public java.lang.String getSMS_QUNFA_EXTCODE() {
        return SMS_QUNFA_EXTCODE;
    }


    /**
     * Sets the SMS_QUNFA_EXTCODE value for this SMSParam.
     * 
     * @param SMS_QUNFA_EXTCODE
     */
    public void setSMS_QUNFA_EXTCODE(java.lang.String SMS_QUNFA_EXTCODE) {
        this.SMS_QUNFA_EXTCODE = SMS_QUNFA_EXTCODE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SMSParam)) return false;
        SMSParam other = (SMSParam) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.SMS_QUNFA_APPID==null && other.getSMS_QUNFA_APPID()==null) || 
             (this.SMS_QUNFA_APPID!=null &&
              this.SMS_QUNFA_APPID.equals(other.getSMS_QUNFA_APPID()))) &&
            ((this.SMS_QUNFA_EXTCODE==null && other.getSMS_QUNFA_EXTCODE()==null) || 
             (this.SMS_QUNFA_EXTCODE!=null &&
              this.SMS_QUNFA_EXTCODE.equals(other.getSMS_QUNFA_EXTCODE())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSMS_QUNFA_APPID() != null) {
            _hashCode += getSMS_QUNFA_APPID().hashCode();
        }
        if (getSMS_QUNFA_EXTCODE() != null) {
            _hashCode += getSMS_QUNFA_EXTCODE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMSParam.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "SMSParam"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMS_QUNFA_APPID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SMS_QUNFA_APPID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMS_QUNFA_EXTCODE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SMS_QUNFA_EXTCODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
