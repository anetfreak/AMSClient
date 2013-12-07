package com.service;

public class EmployeeServiceProxy implements com.service.EmployeeService {
  private String _endpoint = null;
  private com.service.EmployeeService employeeService = null;
  
  public EmployeeServiceProxy() {
    _initEmployeeServiceProxy();
  }
  
  public EmployeeServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeServiceProxy();
  }
  
  private void _initEmployeeServiceProxy() {
    try {
      employeeService = (new com.service.EmployeeServiceServiceLocator()).getEmployeeService();
      if (employeeService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeService != null)
      ((javax.xml.rpc.Stub)employeeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.service.EmployeeService getEmployeeService() {
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService;
  }
  
  public int insertEmployee(com.domain.Employee employee) throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.insertEmployee(employee);
  }
  
  public com.domain.Employee[] getEmployees() throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.getEmployees();
  }
  
  public com.domain.Employee getEmployee(int employeeId) throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.getEmployee(employeeId);
  }
  
  public com.domain.Employee retriveEmployeebypId(int personId) throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.retriveEmployeebypId(personId);
  }
  
  public boolean updateEmployee(com.domain.Employee employee) throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.updateEmployee(employee);
  }
  
  
}