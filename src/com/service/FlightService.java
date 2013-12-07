/**
 * FlightService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service;

public interface FlightService extends java.rmi.Remote {
    public boolean insertFlight(com.domain.Flight flight) throws java.rmi.RemoteException;
    public com.domain.Flight[] getFlights() throws java.rmi.RemoteException;
    public com.domain.Flight getFlightByNo(java.lang.String flightNo) throws java.rmi.RemoteException;
    public com.domain.Flight getFlightById(int flightId) throws java.rmi.RemoteException;
    public com.domain.Flight[] searchFlight(java.lang.String sourceAirport, java.lang.String destAirport, java.lang.String departDate) throws java.rmi.RemoteException;
    public boolean updateFlight(com.domain.Flight flight) throws java.rmi.RemoteException;
}
