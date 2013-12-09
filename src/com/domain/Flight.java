/**
 * Flight.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.domain;

public class Flight  implements java.io.Serializable {
    private java.lang.String airlineName;

    private java.lang.String destination;

    private java.lang.Integer flightId;

    private java.lang.String flightNo;

    private com.domain.FlightTime[] flightTime;

    private com.domain.Journey journey;

    private java.lang.Integer noOfSeats;

    private java.lang.String source;

    public Flight() {
    }

    public Flight(
           java.lang.String airlineName,
           java.lang.String destination,
           java.lang.Integer flightId,
           java.lang.String flightNo,
           com.domain.FlightTime[] flightTime,
           com.domain.Journey journey,
           java.lang.Integer noOfSeats,
           java.lang.String source) {
           this.airlineName = airlineName;
           this.destination = destination;
           this.flightId = flightId;
           this.flightNo = flightNo;
           this.flightTime = flightTime;
           this.journey = journey;
           this.noOfSeats = noOfSeats;
           this.source = source;
    }


    /**
     * Gets the airlineName value for this Flight.
     * 
     * @return airlineName
     */
    public java.lang.String getAirlineName() {
        return airlineName;
    }


    /**
     * Sets the airlineName value for this Flight.
     * 
     * @param airlineName
     */
    public void setAirlineName(java.lang.String airlineName) {
        this.airlineName = airlineName;
    }


    /**
     * Gets the destination value for this Flight.
     * 
     * @return destination
     */
    public java.lang.String getDestination() {
        return destination;
    }


    /**
     * Sets the destination value for this Flight.
     * 
     * @param destination
     */
    public void setDestination(java.lang.String destination) {
        this.destination = destination;
    }


    /**
     * Gets the flightId value for this Flight.
     * 
     * @return flightId
     */
    public java.lang.Integer getFlightId() {
        return flightId;
    }


    /**
     * Sets the flightId value for this Flight.
     * 
     * @param flightId
     */
    public void setFlightId(java.lang.Integer flightId) {
        this.flightId = flightId;
    }


    /**
     * Gets the flightNo value for this Flight.
     * 
     * @return flightNo
     */
    public java.lang.String getFlightNo() {
        return flightNo;
    }


    /**
     * Sets the flightNo value for this Flight.
     * 
     * @param flightNo
     */
    public void setFlightNo(java.lang.String flightNo) {
        this.flightNo = flightNo;
    }


    /**
     * Gets the flightTime value for this Flight.
     * 
     * @return flightTime
     */
    public com.domain.FlightTime[] getFlightTime() {
        return flightTime;
    }


    /**
     * Sets the flightTime value for this Flight.
     * 
     * @param flightTime
     */
    public void setFlightTime(com.domain.FlightTime[] flightTime) {
        this.flightTime = flightTime;
    }


    /**
     * Gets the journey value for this Flight.
     * 
     * @return journey
     */
    public com.domain.Journey getJourney() {
        return journey;
    }


    /**
     * Sets the journey value for this Flight.
     * 
     * @param journey
     */
    public void setJourney(com.domain.Journey journey) {
        this.journey = journey;
    }


    /**
     * Gets the noOfSeats value for this Flight.
     * 
     * @return noOfSeats
     */
    public java.lang.Integer getNoOfSeats() {
        return noOfSeats;
    }


    /**
     * Sets the noOfSeats value for this Flight.
     * 
     * @param noOfSeats
     */
    public void setNoOfSeats(java.lang.Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
    }


    /**
     * Gets the source value for this Flight.
     * 
     * @return source
     */
    public java.lang.String getSource() {
        return source;
    }


    /**
     * Sets the source value for this Flight.
     * 
     * @param source
     */
    public void setSource(java.lang.String source) {
        this.source = source;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Flight)) return false;
        Flight other = (Flight) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.airlineName==null && other.getAirlineName()==null) || 
             (this.airlineName!=null &&
              this.airlineName.equals(other.getAirlineName()))) &&
            ((this.destination==null && other.getDestination()==null) || 
             (this.destination!=null &&
              this.destination.equals(other.getDestination()))) &&
            ((this.flightId==null && other.getFlightId()==null) || 
             (this.flightId!=null &&
              this.flightId.equals(other.getFlightId()))) &&
            ((this.flightNo==null && other.getFlightNo()==null) || 
             (this.flightNo!=null &&
              this.flightNo.equals(other.getFlightNo()))) &&
            ((this.flightTime==null && other.getFlightTime()==null) || 
             (this.flightTime!=null &&
              java.util.Arrays.equals(this.flightTime, other.getFlightTime()))) &&
            ((this.journey==null && other.getJourney()==null) || 
             (this.journey!=null &&
              this.journey.equals(other.getJourney()))) &&
            ((this.noOfSeats==null && other.getNoOfSeats()==null) || 
             (this.noOfSeats!=null &&
              this.noOfSeats.equals(other.getNoOfSeats()))) &&
            ((this.source==null && other.getSource()==null) || 
             (this.source!=null &&
              this.source.equals(other.getSource())));
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
        if (getAirlineName() != null) {
            _hashCode += getAirlineName().hashCode();
        }
        if (getDestination() != null) {
            _hashCode += getDestination().hashCode();
        }
        if (getFlightId() != null) {
            _hashCode += getFlightId().hashCode();
        }
        if (getFlightNo() != null) {
            _hashCode += getFlightNo().hashCode();
        }
        if (getFlightTime() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFlightTime());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFlightTime(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getJourney() != null) {
            _hashCode += getJourney().hashCode();
        }
        if (getNoOfSeats() != null) {
            _hashCode += getNoOfSeats().hashCode();
        }
        if (getSource() != null) {
            _hashCode += getSource().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Flight.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domain.com", "Flight"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airlineName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "airlineName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destination");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "destination"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "flightId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "flightNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flightTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "flightTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.com", "FlightTime"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.com", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("journey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "journey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.com", "Journey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noOfSeats");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "noOfSeats"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "source"));
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
