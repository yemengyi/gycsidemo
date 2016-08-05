/**
 * SMSRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gycsi.client;

public class SMSRes  implements java.io.Serializable {
    private java.lang.String rtnCode;

    private java.lang.String rtnInfo;

    public SMSRes() {
    }

    public SMSRes(
           java.lang.String rtnCode,
           java.lang.String rtnInfo) {
           this.rtnCode = rtnCode;
           this.rtnInfo = rtnInfo;
    }


    /**
     * Gets the rtnCode value for this SMSRes.
     * 
     * @return rtnCode
     */
    public java.lang.String getRtnCode() {
        return rtnCode;
    }


    /**
     * Sets the rtnCode value for this SMSRes.
     * 
     * @param rtnCode
     */
    public void setRtnCode(java.lang.String rtnCode) {
        this.rtnCode = rtnCode;
    }


    /**
     * Gets the rtnInfo value for this SMSRes.
     * 
     * @return rtnInfo
     */
    public java.lang.String getRtnInfo() {
        return rtnInfo;
    }


    /**
     * Sets the rtnInfo value for this SMSRes.
     * 
     * @param rtnInfo
     */
    public void setRtnInfo(java.lang.String rtnInfo) {
        this.rtnInfo = rtnInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SMSRes)) return false;
        SMSRes other = (SMSRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rtnCode==null && other.getRtnCode()==null) || 
             (this.rtnCode!=null &&
              this.rtnCode.equals(other.getRtnCode()))) &&
            ((this.rtnInfo==null && other.getRtnInfo()==null) || 
             (this.rtnInfo!=null &&
              this.rtnInfo.equals(other.getRtnInfo())));
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
        if (getRtnCode() != null) {
            _hashCode += getRtnCode().hashCode();
        }
        if (getRtnInfo() != null) {
            _hashCode += getRtnInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMSRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "SMSRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtnCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rtnCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtnInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rtnInfo"));
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
