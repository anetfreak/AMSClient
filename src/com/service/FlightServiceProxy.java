package com.service;

public class FlightServiceProxy implements com.service.FlightService {
  private String _endpoint = null;
  private com.service.FlightService flightService = null;
  
  public FlightServiceProxy() {
    _initFlightServiceProxy();
  }
  
  public FlightServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initFlightServiceProxy();
  }
  
  private void _initFlightServiceProxy() {
    try {
      flightService = (new com.service.FlightServiceServiceLocator()).getFlightService();
      if (flightService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)flightService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)flightService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (flightService != null)
      ((javax.xml.rpc.Stub)flightService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.service.FlightService getFlightService() {
    if (flightService == null)
      _initFlightServiceProxy();
    return flightService;
  }
  
  public com.domain.Location[] getLocations() throws java.rmi.RemoteException{
    if (flightService == null)
      _initFlightServiceProxy();
    return flightService.getLocations();
  }
  
  public com.domain.Flight getFlightById(int flightId) throws java.rmi.RemoteException{
    if (flightService == null)
      _initFlightServiceProxy();
    return flightService.getFlightById(flightId);
  }
  
  public com.domain.Flight getFlightByNo(java.lang.String flightNo) throws java.rmi.RemoteException{
    if (flightService == null)
      _initFlightServiceProxy();
    return flightService.getFlightByNo(flightNo);
  }
  
  public boolean insertFlight(com.domain.Flight flight) throws java.rmi.RemoteException{
    if (flightService == null)
      _initFlightServiceProxy();
    return flightService.insertFlight(flight);
  }
  
  public com.domain.Flight[] searchFlight(java.lang.String sourceAirport, java.lang.String destAirport, java.lang.String departDate) throws java.rmi.RemoteException{
    if (flightService == null)
      _initFlightServiceProxy();
    return flightService.searchFlight(sourceAirport, destAirport, departDate);
  }
  
  public com.domain.Flight[] getFlights() throws java.rmi.RemoteException{
    if (flightService == null)
      _initFlightServiceProxy();
    return flightService.getFlights();
  }
  
  public boolean updateFlight(com.domain.Flight flight) throws java.rmi.RemoteException{
    if (flightService == null)
      _initFlightServiceProxy();
    return flightService.updateFlight(flight);
  }
  
  
}