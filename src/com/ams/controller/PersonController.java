package com.ams.controller;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Customer;
import com.domain.Employee;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;

@Controller
public class PersonController {

	CustomerServiceProxy custProxy = new CustomerServiceProxy();
	EmployeeServiceProxy empProxy = new EmployeeServiceProxy();
	
		@RequestMapping(value = "/ListCustomers.htm", method = RequestMethod.GET)
	  public ModelAndView showCustomers() {
		
		Customer[] customer = null;

		custProxy.setEndpoint("http://localhost:8080/AMS/services/CustomerService");
		
		try {
			customer = custProxy.getCustomers();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		List<Customer> customers = null;
		if(customer != null)
		{
			customers = Arrays.asList(customer);
		}
		
		return new ModelAndView("ListCustomers","Customers",customers);
	}
	
		@RequestMapping(value = "/ListEmployees.htm", method = RequestMethod.GET)
	public ModelAndView showEmployees() {
		
		Employee[] employee = null;

		empProxy.setEndpoint("http://localhost:8080/AMS/services/EmployeeService");
		
		try {
			employee = empProxy.getEmployees();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		List<Employee> employees = null;
		if(employee != null)
		{
			employees = Arrays.asList(employee);
		}
		
		return new ModelAndView("ListEmployees","Employees",employees);
	}
		
		
	@RequestMapping(value = "/searchEmployee.htm", method = RequestMethod.GET)
	public ModelAndView showSearchEmployee() {
		return new ModelAndView("search_employee");
	}
	
	@RequestMapping(value = "/searchEmployees.htm", method = RequestMethod.POST)
	public ModelAndView searchEmployees(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname) {
		//TODO- Search employee call here..
		return new ModelAndView("search_employee");
	}
}
