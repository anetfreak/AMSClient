/**
 * FlightTime.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.domain;

public class FlightTime  implements java.io.Serializable {
    private java.lang.String flightDay;

    private java.lang.String flightTime;

    public FlightTime() {
    }

    public FlightTime(
           java.lang.String flightDay,
           java.lang.String flightTime) {
           this.flightDay = flightDay;
           this.flightTime = flightTime;
    }


    /**
     * Gets the flightDay value for this FlightTime.
     * 
     * @return flightDay
     */
    public java.lang.String getFlightDay() {
        return flightDay;
    }


    /**
     * Sets the flightDay value for this FlightTime.
     * 
     * @param flightDay
     */
    public void setFlightDay(java.lang.String flightDay) {
        this.flightDay = flightDay;
    }


    /**
     * Gets the flightTime value for this FlightTime.
     * 
     * @return flightTime
     */
    public java.lang.String getFlightTime() {
        return flightTime;
    }


    /**
     * Sets the flightTime value for this FlightTime.
     * 
     * @param flightTime
     */
    public void setFlightTime(java.lang.String flightTime) {
        this.flightTime = flightTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightTime)) return false;
        FlightTime other = (FlightTime) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.flightDay==null && other.getFlightDay()==null) || 
             (this.flightDay!=null &&
              this.flightDay.equals(other.getFlightDay()))) &&
            ((this.flightTime==null && other.getFlightTime()==null) || 
             (this.flightTime!=null &&
              this.flightTime.equals(other.getFlightTime())));
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
        if (getFlightDay() != null) {
            _hashCode += getFlightDay().hashCode();
        }
        if (getFlightTime() != null) {
            _hashCode += getFlightTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlightTime.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domain.com", "FlightTime"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightDay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "flightDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "flightTime"));
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
