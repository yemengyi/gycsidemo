/**
 * SMSMsg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gycsi.client;

public class SMSMsg  implements java.io.Serializable {
    private java.lang.String destNumber;

    private java.lang.String msgContent;

    private java.lang.String msgFormat;

    private java.lang.String senderAddress;

    public SMSMsg() {
    }

    public SMSMsg(
           java.lang.String destNumber,
           java.lang.String msgContent,
           java.lang.String msgFormat,
           java.lang.String senderAddress) {
           this.destNumber = destNumber;
           this.msgContent = msgContent;
           this.msgFormat = msgFormat;
           this.senderAddress = senderAddress;
    }


    /**
     * Gets the destNumber value for this SMSMsg.
     * 
     * @return destNumber
     */
    public java.lang.String getDestNumber() {
        return destNumber;
    }


    /**
     * Sets the destNumber value for this SMSMsg.
     * 
     * @param destNumber
     */
    public void setDestNumber(java.lang.String destNumber) {
        this.destNumber = destNumber;
    }


    /**
     * Gets the msgContent value for this SMSMsg.
     * 
     * @return msgContent
     */
    public java.lang.String getMsgContent() {
        return msgContent;
    }


    /**
     * Sets the msgContent value for this SMSMsg.
     * 
     * @param msgContent
     */
    public void setMsgContent(java.lang.String msgContent) {
        this.msgContent = msgContent;
    }


    /**
     * Gets the msgFormat value for this SMSMsg.
     * 
     * @return msgFormat
     */
    public java.lang.String getMsgFormat() {
        return msgFormat;
    }


    /**
     * Sets the msgFormat value for this SMSMsg.
     * 
     * @param msgFormat
     */
    public void setMsgFormat(java.lang.String msgFormat) {
        this.msgFormat = msgFormat;
    }


    /**
     * Gets the senderAddress value for this SMSMsg.
     * 
     * @return senderAddress
     */
    public java.lang.String getSenderAddress() {
        return senderAddress;
    }


    /**
     * Sets the senderAddress value for this SMSMsg.
     * 
     * @param senderAddress
     */
    public void setSenderAddress(java.lang.String senderAddress) {
        this.senderAddress = senderAddress;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SMSMsg)) return false;
        SMSMsg other = (SMSMsg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.destNumber==null && other.getDestNumber()==null) || 
             (this.destNumber!=null &&
              this.destNumber.equals(other.getDestNumber()))) &&
            ((this.msgContent==null && other.getMsgContent()==null) || 
             (this.msgContent!=null &&
              this.msgContent.equals(other.getMsgContent()))) &&
            ((this.msgFormat==null && other.getMsgFormat()==null) || 
             (this.msgFormat!=null &&
              this.msgFormat.equals(other.getMsgFormat()))) &&
            ((this.senderAddress==null && other.getSenderAddress()==null) || 
             (this.senderAddress!=null &&
              this.senderAddress.equals(other.getSenderAddress())));
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
        if (getDestNumber() != null) {
            _hashCode += getDestNumber().hashCode();
        }
        if (getMsgContent() != null) {
            _hashCode += getMsgContent().hashCode();
        }
        if (getMsgFormat() != null) {
            _hashCode += getMsgFormat().hashCode();
        }
        if (getSenderAddress() != null) {
            _hashCode += getSenderAddress().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMSMsg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "SMSMsg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "destNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgContent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msgFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senderAddress"));
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
