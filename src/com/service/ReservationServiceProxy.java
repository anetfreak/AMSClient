package com.service;

public class ReservationServiceProxy implements com.service.ReservationService {
  private String _endpoint = null;
  private com.service.ReservationService reservationService = null;
  
  public ReservationServiceProxy() {
    _initReservationServiceProxy();
  }
  
  public ReservationServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initReservationServiceProxy();
  }
  
  private void _initReservationServiceProxy() {
    try {
      reservationService = (new com.service.ReservationServiceServiceLocator()).getReservationService();
      if (reservationService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)reservationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)reservationService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (reservationService != null)
      ((javax.xml.rpc.Stub)reservationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.service.ReservationService getReservationService() {
    if (reservationService == null)
      _initReservationServiceProxy();
    return reservationService;
  }
  
  public com.domain.Reservation[] getReservationbyCustId(int customerId) throws java.rmi.RemoteException{
    if (reservationService == null)
      _initReservationServiceProxy();
    return reservationService.getReservationbyCustId(customerId);
  }
  
  public boolean cancelReservation(int reservationId) throws java.rmi.RemoteException{
    if (reservationService == null)
      _initReservationServiceProxy();
    return reservationService.cancelReservation(reservationId);
  }
  
  public boolean insertReservation(com.domain.Reservation reservation) throws java.rmi.RemoteException{
    if (reservationService == null)
      _initReservationServiceProxy();
    return reservationService.insertReservation(reservation);
  }
  
  public com.domain.Reservation getReservation(int reservationId) throws java.rmi.RemoteException{
    if (reservationService == null)
      _initReservationServiceProxy();
    return reservationService.getReservation(reservationId);
  }
  
  public com.domain.Reservation[] getReservations() throws java.rmi.RemoteException{
    if (reservationService == null)
      _initReservationServiceProxy();
    return reservationService.getReservations();
  }
  
  public boolean updateReservation(com.domain.Reservation reservation) throws java.rmi.RemoteException{
    if (reservationService == null)
      _initReservationServiceProxy();
    return reservationService.updateReservation(reservation);
  }
  
  
}