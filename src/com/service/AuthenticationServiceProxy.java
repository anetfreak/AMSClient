package com.service;

public class AuthenticationServiceProxy implements com.service.AuthenticationService {
  private String _endpoint = null;
  private com.service.AuthenticationService authenticationService = null;
  
  public AuthenticationServiceProxy() {
    _initAuthenticationServiceProxy();
  }
  
  public AuthenticationServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAuthenticationServiceProxy();
  }
  
  private void _initAuthenticationServiceProxy() {
    try {
      authenticationService = (new com.service.AuthenticationServiceServiceLocator()).getAuthenticationService();
      if (authenticationService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)authenticationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)authenticationService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (authenticationService != null)
      ((javax.xml.rpc.Stub)authenticationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.service.AuthenticationService getAuthenticationService() {
    if (authenticationService == null)
      _initAuthenticationServiceProxy();
    return authenticationService;
  }
  
  public boolean updateEmpInformation(com.domain.Employee employee) throws java.rmi.RemoteException{
    if (authenticationService == null)
      _initAuthenticationServiceProxy();
    return authenticationService.updateEmpInformation(employee);
  }
  
  public boolean updateCustInformation(com.domain.Customer customer) throws java.rmi.RemoteException{
    if (authenticationService == null)
      _initAuthenticationServiceProxy();
    return authenticationService.updateCustInformation(customer);
  }
  
  public boolean employeeSignUp(com.domain.Employee employee) throws java.rmi.RemoteException{
    if (authenticationService == null)
      _initAuthenticationServiceProxy();
    return authenticationService.employeeSignUp(employee);
  }
  
  public int signInEmployee(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (authenticationService == null)
      _initAuthenticationServiceProxy();
    return authenticationService.signInEmployee(username, password);
  }
  
  public int signInCustomer(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (authenticationService == null)
      _initAuthenticationServiceProxy();
    return authenticationService.signInCustomer(username, password);
  }
  
  public boolean customerSignUp(com.domain.Customer customer) throws java.rmi.RemoteException{
    if (authenticationService == null)
      _initAuthenticationServiceProxy();
    return authenticationService.customerSignUp(customer);
  }
  
  
}