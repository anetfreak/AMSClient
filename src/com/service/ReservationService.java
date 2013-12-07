/**
 * ReservationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service;

public interface ReservationService extends java.rmi.Remote {
    public com.domain.Reservation[] getReservations() throws java.rmi.RemoteException;
    public boolean insertReservation(com.domain.Reservation reservation) throws java.rmi.RemoteException;
    public com.domain.Reservation getReservation(int reservationId) throws java.rmi.RemoteException;
    public boolean updateReservation(com.domain.Reservation reservation) throws java.rmi.RemoteException;
}
