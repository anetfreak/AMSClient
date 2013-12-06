/**
 * Reservation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.domain;

public class Reservation  implements java.io.Serializable {
    private java.lang.Integer reservationId;

    private java.lang.String reservationNo;

    private java.lang.Integer reservationStatus;

    private java.lang.Integer seatsBooked;

    private com.domain.Traveller[] travellers;

    public Reservation() {
    }

    public Reservation(
           java.lang.Integer reservationId,
           java.lang.String reservationNo,
           java.lang.Integer reservationStatus,
           java.lang.Integer seatsBooked,
           com.domain.Traveller[] travellers) {
           this.reservationId = reservationId;
           this.reservationNo = reservationNo;
           this.reservationStatus = reservationStatus;
           this.seatsBooked = seatsBooked;
           this.travellers = travellers;
    }


    /**
     * Gets the reservationId value for this Reservation.
     * 
     * @return reservationId
     */
    public java.lang.Integer getReservationId() {
        return reservationId;
    }


    /**
     * Sets the reservationId value for this Reservation.
     * 
     * @param reservationId
     */
    public void setReservationId(java.lang.Integer reservationId) {
        this.reservationId = reservationId;
    }


    /**
     * Gets the reservationNo value for this Reservation.
     * 
     * @return reservationNo
     */
    public java.lang.String getReservationNo() {
        return reservationNo;
    }


    /**
     * Sets the reservationNo value for this Reservation.
     * 
     * @param reservationNo
     */
    public void setReservationNo(java.lang.String reservationNo) {
        this.reservationNo = reservationNo;
    }


    /**
     * Gets the reservationStatus value for this Reservation.
     * 
     * @return reservationStatus
     */
    public java.lang.Integer getReservationStatus() {
        return reservationStatus;
    }


    /**
     * Sets the reservationStatus value for this Reservation.
     * 
     * @param reservationStatus
     */
    public void setReservationStatus(java.lang.Integer reservationStatus) {
        this.reservationStatus = reservationStatus;
    }


    /**
     * Gets the seatsBooked value for this Reservation.
     * 
     * @return seatsBooked
     */
    public java.lang.Integer getSeatsBooked() {
        return seatsBooked;
    }


    /**
     * Sets the seatsBooked value for this Reservation.
     * 
     * @param seatsBooked
     */
    public void setSeatsBooked(java.lang.Integer seatsBooked) {
        this.seatsBooked = seatsBooked;
    }


    /**
     * Gets the travellers value for this Reservation.
     * 
     * @return travellers
     */
    public com.domain.Traveller[] getTravellers() {
        return travellers;
    }


    /**
     * Sets the travellers value for this Reservation.
     * 
     * @param travellers
     */
    public void setTravellers(com.domain.Traveller[] travellers) {
        this.travellers = travellers;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Reservation)) return false;
        Reservation other = (Reservation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.reservationId==null && other.getReservationId()==null) || 
             (this.reservationId!=null &&
              this.reservationId.equals(other.getReservationId()))) &&
            ((this.reservationNo==null && other.getReservationNo()==null) || 
             (this.reservationNo!=null &&
              this.reservationNo.equals(other.getReservationNo()))) &&
            ((this.reservationStatus==null && other.getReservationStatus()==null) || 
             (this.reservationStatus!=null &&
              this.reservationStatus.equals(other.getReservationStatus()))) &&
            ((this.seatsBooked==null && other.getSeatsBooked()==null) || 
             (this.seatsBooked!=null &&
              this.seatsBooked.equals(other.getSeatsBooked()))) &&
            ((this.travellers==null && other.getTravellers()==null) || 
             (this.travellers!=null &&
              java.util.Arrays.equals(this.travellers, other.getTravellers())));
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
        if (getReservationId() != null) {
            _hashCode += getReservationId().hashCode();
        }
        if (getReservationNo() != null) {
            _hashCode += getReservationNo().hashCode();
        }
        if (getReservationStatus() != null) {
            _hashCode += getReservationStatus().hashCode();
        }
        if (getSeatsBooked() != null) {
            _hashCode += getSeatsBooked().hashCode();
        }
        if (getTravellers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTravellers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTravellers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Reservation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domain.com", "Reservation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reservationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "reservationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reservationNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "reservationNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reservationStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "reservationStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seatsBooked");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "seatsBooked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("travellers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domain.com", "travellers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://domain.com", "Traveller"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.com", "item"));
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
