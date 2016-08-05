/**
 * SMSDeliveryStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gycsi.client;

public class SMSDeliveryStatus  implements java.io.Serializable {
    private java.lang.String address;

    private java.lang.String deliveryStatus;

    public SMSDeliveryStatus() {
    }

    public SMSDeliveryStatus(
           java.lang.String address,
           java.lang.String deliveryStatus) {
           this.address = address;
           this.deliveryStatus = deliveryStatus;
    }


    /**
     * Gets the address value for this SMSDeliveryStatus.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this SMSDeliveryStatus.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the deliveryStatus value for this SMSDeliveryStatus.
     * 
     * @return deliveryStatus
     */
    public java.lang.String getDeliveryStatus() {
        return deliveryStatus;
    }


    /**
     * Sets the deliveryStatus value for this SMSDeliveryStatus.
     * 
     * @param deliveryStatus
     */
    public void setDeliveryStatus(java.lang.String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SMSDeliveryStatus)) return false;
        SMSDeliveryStatus other = (SMSDeliveryStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.deliveryStatus==null && other.getDeliveryStatus()==null) || 
             (this.deliveryStatus!=null &&
              this.deliveryStatus.equals(other.getDeliveryStatus())));
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
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getDeliveryStatus() != null) {
            _hashCode += getDeliveryStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMSDeliveryStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "SMSDeliveryStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliveryStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deliveryStatus"));
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
