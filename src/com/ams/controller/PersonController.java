package com.ams.controller;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Customer;
import com.domain.Employee;
import com.domain.Flight;
import com.domain.FlightTime;
import com.domain.Response;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;

@Controller
public class PersonController {

	private static final String VIEW_NAME = "commonJsonView";
	CustomerServiceProxy custProxy = new CustomerServiceProxy();
	EmployeeServiceProxy empProxy = new EmployeeServiceProxy();

	@RequestMapping(value = "/ListCustomers.htm", method = RequestMethod.GET)
	public ModelAndView showCustomers() {

		Customer[] customer = null;

		custProxy.setEndpoint("http://localhost:8080/AMS/services/CustomerService");
		try 
		{
			customer = custProxy.getCustomers();
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}

		List<Customer> customers = null;
		if(customer != null)
		{
			customers = Arrays.asList(customer);
		}
		return new ModelAndView("ListCustomers","Customers",customers);
	}

	@RequestMapping(value = "/deleteCustomer/{customerId}.htm", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@PathVariable("customerId") int customerId) {

		custProxy.setEndpoint("http://localhost:8080/AMS/services/CustomerService");
		Response response = null;
		try 
		{
			System.out.println(customerId);
			boolean b = custProxy.deleteCustomer(customerId);
			if(b)
			{
				System.out.println("Customer Deleted.!!");
				response = new Response ("success");
			}
			else
			{
				System.out.println("Cant delete customer..");
				response = new Response("failure");
			}
		} 
		catch (RemoteException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Function repeat..
		
		Customer[] customer = null;

		try 
		{
			customer = custProxy.getCustomers();
		} 
		catch (RemoteException e) 
		{
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

		try 
		{
			employee = empProxy.getEmployees();
		} 
		catch (RemoteException e) 
		{
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

	@RequestMapping(value = "/searchEmployee.htm", method = RequestMethod.POST)
	public ModelAndView searchEmployees(
			@RequestParam(value="firstname", required=false) String firstname,
			@RequestParam(value="lastname", required=false) String lastname) {

		ModelAndView modelAndView = new ModelAndView("search_employee");
		empProxy.setEndpoint("http://localhost:8080/AMS/services/EmployeeService");
		Employee[] employee = null;
		try 
		{
			employee = empProxy.retriveEmployeesbyName(firstname, lastname);
		} 
		catch (RemoteException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Employee> employees = null;
		if(employee != null)
		{
			employees = Arrays.asList(employee);
		}
		
		modelAndView.addObject("employees",employees);
		return modelAndView;

	}
	
	@RequestMapping(value = "/deleteEmployee/{employeeId}.htm", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable("employeeId") int employeeId) {

		empProxy.setEndpoint("http://localhost:8080/AMS/services/EmployeeService");
		Response response = null;
		try 
		{
			System.out.println("Employee ID "+ employeeId);
			boolean b = empProxy.deleteEmployee(employeeId);
			if(b)
			{
				System.out.println("Employee Deleted.!!");
				response = new Response ("success");
			}
			else
			{
				System.out.println("Cant delete employee..");
				response = new Response("failure");
			}
		} 
		catch (RemoteException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Function repeat..
		
		Employee[] employee = null;

		try 
		{
			employee = empProxy.getEmployees();
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
		List<Employee> employees = null;
		if(employee != null)
		{
			employees = Arrays.asList(employee);
		}

		return new ModelAndView("ListEmployees","Employees",employees);
	}
}
