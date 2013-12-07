/**
 * EmployeeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service;

public interface EmployeeService extends java.rmi.Remote {
    public int insertEmployee(com.domain.Employee employee) throws java.rmi.RemoteException;
    public com.domain.Employee[] getEmployees() throws java.rmi.RemoteException;
    public com.domain.Employee getEmployee(int employeeId) throws java.rmi.RemoteException;
    public com.domain.Employee retriveEmployeebypId(int personId) throws java.rmi.RemoteException;
    public boolean updateEmployee(com.domain.Employee employee) throws java.rmi.RemoteException;
}
