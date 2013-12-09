/**
 * PersonServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service;

public class PersonServiceServiceLocator extends org.apache.axis.client.Service implements com.service.PersonServiceService {

    public PersonServiceServiceLocator() {
    }


    public PersonServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PersonServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PersonService
    private java.lang.String PersonService_address = "http://localhost:8080/AMS/services/PersonService";

    public java.lang.String getPersonServiceAddress() {
        return PersonService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PersonServiceWSDDServiceName = "PersonService";

    public java.lang.String getPersonServiceWSDDServiceName() {
        return PersonServiceWSDDServiceName;
    }

    public void setPersonServiceWSDDServiceName(java.lang.String name) {
        PersonServiceWSDDServiceName = name;
    }

    public com.service.PersonService getPersonService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PersonService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPersonService(endpoint);
    }

    public com.service.PersonService getPersonService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.service.PersonServiceSoapBindingStub _stub = new com.service.PersonServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getPersonServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPersonServiceEndpointAddress(java.lang.String address) {
        PersonService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.service.PersonService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.service.PersonServiceSoapBindingStub _stub = new com.service.PersonServiceSoapBindingStub(new java.net.URL(PersonService_address), this);
                _stub.setPortName(getPersonServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PersonService".equals(inputPortName)) {
            return getPersonService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.com", "PersonServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.com", "PersonService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PersonService".equals(portName)) {
            setPersonServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
