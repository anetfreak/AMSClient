/**
 * CustomerServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service;

public interface CustomerServiceService extends javax.xml.rpc.Service {
    public java.lang.String getCustomerServiceAddress();

    public com.service.CustomerService getCustomerService() throws javax.xml.rpc.ServiceException;

    public com.service.CustomerService getCustomerService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
