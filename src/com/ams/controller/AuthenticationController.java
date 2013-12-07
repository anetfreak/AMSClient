package com.ams.controller;

import java.rmi.RemoteException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Customer;
import com.domain.Employee;
import com.domain.Person;
import com.domain.Response;
import com.service.AuthenticationServiceProxy;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;

@Controller
public class AuthenticationController {

	private static final String VIEW_NAME = "commonJsonView";
	AuthenticationServiceProxy authProxy=new AuthenticationServiceProxy(); 
	CustomerServiceProxy custProxy = new CustomerServiceProxy();
	EmployeeServiceProxy empProxy = new EmployeeServiceProxy();

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("userType") Integer userType,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Response response = null;
		Customer customer = null;


		authProxy.setEndpoint("http://localhost:8080/AMS/services/AuthenticationService");

		if(userType == 0)
		{
			System.out.println("You are a Customer");
			try 
			{
				int personId = authProxy.signInCustomer(email, password);
				if(personId < 0)
				{
					System.out.println("Failed to login  - inside customer");
					response = new Response("failure");
				}
				else
				{
					System.out.println("Customer entry is present in database");
					custProxy.setEndpoint("http://localhost:8080/AMS/services/CustomerService");

					customer = custProxy.retriveCustomerbypId(personId);
					if(customer == null)
					{
						System.out.println("Customer is null");
						response = new Response("failure");
					}
					else
					{
						String firstName = customer.getPerson().getFirstName();
						int customerId = customer.getCustomerId();

						session.setAttribute("firstname", firstName);
						session.setAttribute("customerId", customerId);
						session.setAttribute("sessionId", session.getId());
						System.out.println("Session sttributes set for Customer..!!");
						response = new Response("success");
					}
				}
			} 
			catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception in signin - customer");
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("You are an Employee");
			try 
			{
				int personId = authProxy.signInEmployee(email, password);
				if(personId < 0)
				{
					System.out.println("Failed to login");
					response = new Response("failure");
				}
				else
				{
					System.out.println("Employee is present in database..!!");

					empProxy.setEndpoint("http://localhost:8080/AMS/services/EmployeeService");

					Employee employee = null;
					employee = empProxy.retriveEmployeebypId(personId);
					if(employee == null)
					{
						System.out.println("employee is null");
						response = new Response("failure");
					}
					else
					{
						String firstName = employee.getPerson().getFirstName();
						int employeeId = employee.getEmployeeId();

						session.setAttribute("firstname", firstName);
						session.setAttribute("employeeId", employeeId);
						session.setAttribute("sessionId", session.getId());
						System.out.println("Session sttributes set for Employee..!!");
						response = new Response("success");
					} 
				}
			}
			catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception in signin - employee");
				e.printStackTrace();
			}

		}

		return new ModelAndView(VIEW_NAME, "result", response);
	}

	@RequestMapping(value = "/signup.htm", method = RequestMethod.GET)
	public ModelAndView showSignup() {
		return new ModelAndView("signup");
	}

	
	@RequestMapping(value = "/signup.htm", method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam("fname") String fname, 
			@RequestParam("lname") String lname, 
			@RequestParam("email") String email,
			@RequestParam("password") String password, 
			@RequestParam("address") String address,
			@RequestParam("city") String city,
			@RequestParam("state") String state,
			@RequestParam("pincode") Integer pincode,
			@RequestParam("dob") String dob,
			@RequestParam("passport") String passport,
			@RequestParam("nationality") String nationality,
			@RequestParam("workdesc") String workdesc,
			@RequestParam("position") String position,
			@RequestParam("hiredate") String hiredate,
			@RequestParam("userType") Integer userType,
			HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();

		authProxy.setEndpoint("http://localhost:8080/AMS/services/AuthenticationService");
		Employee employee = null;
		Customer customer = null;
		
		Person person = null;
		person.setFirstName(fname);
		person.setLastName(lname);
		person.setAddress(address);
		person.setCity(city);
		person.setState(state);
		person.setZip(pincode);
		person.setDOB(dob);
		person.setUsername(email);
		person.setPassword(password);
		person.setPersonType(userType);
		
		if(userType == 0)
		{
			System.out.println("You are an employee");
			
			try 
			{
				employee.setHireDate(hiredate);
				employee.setPosition(position);
				employee.setWorkDesc(workdesc);
				employee.setPerson(person);
				
				int employeeId = authProxy.employeeSignUp(employee);
				
				if(employeeId > 0)
				{
					System.out.println("Employee Created..!!");
					System.out.println("Employee ID : "+employeeId);
				}
			}
			catch (RemoteException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Exception in employee creation");
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("You are a customer");
		}



	
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("home");
	}

	//	@RequestMapping(value = "/checkUserRegistered.htm", method = RequestMethod.POST)
	//	public ModelAndView checkUser(@RequestParam("email") String email, HttpSession session) {
	//		Response response = null;
	//		boolean exists = userFacade.checkInUser(email);
	//		if(exists) {
	//			response = new Response("exists");
	//			User user = userFacade.getInUser(email);
	//			session.setAttribute("user", user);
	//			session.setAttribute("sessionId", session.getId());
	//		} else {
	//			response = new Response("newUser");
	//		}
	//		
	//		return new ModelAndView(VIEW_NAME, "result", response);
	//	}

}
