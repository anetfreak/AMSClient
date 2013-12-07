/**
 * CustomerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service;

public interface CustomerService extends java.rmi.Remote {
    public boolean updateCustomer(com.domain.Customer customer) throws java.rmi.RemoteException;
    public com.domain.Customer retriveCustomerbypId(int personId) throws java.rmi.RemoteException;
    public int insertCustomer(com.domain.Customer customer) throws java.rmi.RemoteException;
    public com.domain.Customer[] getCustomers() throws java.rmi.RemoteException;
    public com.domain.Customer getCustomer(int customerId) throws java.rmi.RemoteException;
}
