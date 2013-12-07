/**
 * AuthenticationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service;

public interface AuthenticationService extends java.rmi.Remote {
    public int signInEmployee(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public int employeeSignUp(com.domain.Employee employee) throws java.rmi.RemoteException;
    public int signInCustomer(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public int customerSignUp(com.domain.Customer customer) throws java.rmi.RemoteException;
    public boolean updateCustInformation(com.domain.Customer customer) throws java.rmi.RemoteException;
    public boolean updateEmpInformation(com.domain.Employee employee) throws java.rmi.RemoteException;
}
