package com.service;

public class PersonServiceProxy implements com.service.PersonService {
  private String _endpoint = null;
  private com.service.PersonService personService = null;
  
  public PersonServiceProxy() {
    _initPersonServiceProxy();
  }
  
  public PersonServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonServiceProxy();
  }
  
  private void _initPersonServiceProxy() {
    try {
      personService = (new com.service.PersonServiceServiceLocator()).getPersonService();
      if (personService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personService != null)
      ((javax.xml.rpc.Stub)personService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.service.PersonService getPersonService() {
    if (personService == null)
      _initPersonServiceProxy();
    return personService;
  }
  
  public com.domain.Person getPerson(int personId) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.getPerson(personId);
  }
  
  public boolean validatePerson(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.validatePerson(username, password);
  }
  
  public boolean insertPerson(com.domain.Person person) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.insertPerson(person);
  }
  
  public boolean updatePerson(com.domain.Person person) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.updatePerson(person);
  }
  
  
}