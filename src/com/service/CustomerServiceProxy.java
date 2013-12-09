package com.service;

public class CustomerServiceProxy implements com.service.CustomerService {
  private String _endpoint = null;
  private com.service.CustomerService customerService = null;
  
  public CustomerServiceProxy() {
    _initCustomerServiceProxy();
  }
  
  public CustomerServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCustomerServiceProxy();
  }
  
  private void _initCustomerServiceProxy() {
    try {
      customerService = (new com.service.CustomerServiceServiceLocator()).getCustomerService();
      if (customerService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)customerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)customerService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (customerService != null)
      ((javax.xml.rpc.Stub)customerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.service.CustomerService getCustomerService() {
    if (customerService == null)
      _initCustomerServiceProxy();
    return customerService;
  }
  
  public int insertCustomer(com.domain.Customer customer) throws java.rmi.RemoteException{
    if (customerService == null)
      _initCustomerServiceProxy();
    return customerService.insertCustomer(customer);
  }
  
  public boolean updateCustomer(com.domain.Customer customer) throws java.rmi.RemoteException{
    if (customerService == null)
      _initCustomerServiceProxy();
    return customerService.updateCustomer(customer);
  }
  
  public boolean deleteCustomer(int customerId) throws java.rmi.RemoteException{
    if (customerService == null)
      _initCustomerServiceProxy();
    return customerService.deleteCustomer(customerId);
  }
  
  public com.domain.Customer getCustomer(int customerId) throws java.rmi.RemoteException{
    if (customerService == null)
      _initCustomerServiceProxy();
    return customerService.getCustomer(customerId);
  }
  
  public com.domain.Customer retriveCustomerbypId(int personId) throws java.rmi.RemoteException{
    if (customerService == null)
      _initCustomerServiceProxy();
    return customerService.retriveCustomerbypId(personId);
  }
  
  public com.domain.Customer[] getCustomers() throws java.rmi.RemoteException{
    if (customerService == null)
      _initCustomerServiceProxy();
    return customerService.getCustomers();
  }
  
  
}