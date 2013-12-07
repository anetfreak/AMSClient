/**
 * PersonService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service;

public interface PersonService extends java.rmi.Remote {
    public com.domain.Person getPerson(int personId) throws java.rmi.RemoteException;
    public boolean validatePerson(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public boolean insertPerson(com.domain.Person person) throws java.rmi.RemoteException;
    public boolean updatePerson(com.domain.Person person) throws java.rmi.RemoteException;
}
