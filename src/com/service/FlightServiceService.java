/**
 * FlightServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service;

public interface FlightServiceService extends javax.xml.rpc.Service {
    public java.lang.String getFlightServiceAddress();

    public com.service.FlightService getFlightService() throws javax.xml.rpc.ServiceException;

    public com.service.FlightService getFlightService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
