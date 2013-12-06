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
import com.service.AuthenticationServiceProxy;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;

@Controller
public class AuthenticationController {

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
					modelAndView.setViewName("login");
				}
				else
				{
					System.out.println("Customer entry is present in database");
					custProxy.setEndpoint("http://localhost:8080/AMS/services/CustomerService");

					customer = custProxy.retriveCustomerbypId(personId);
					if(customer == null)
					{
						System.out.println("Customer is null");
						modelAndView.setViewName("login");
					}
					else
					{
						String firstName = customer.getPerson().getFirstName();
						int customerId = customer.getCustomerId();

						session.setAttribute("firstname", firstName);
						session.setAttribute("customerId", customerId);
						session.setAttribute("sessionId", session.getId());
						System.out.println("Session sttributes set for Customer..!!");
						modelAndView.setViewName("home");
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
					modelAndView.setViewName("login");
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
						modelAndView.setViewName("login");
					}
					else
					{
						String firstName = employee.getPerson().getFirstName();
						int employeeId = employee.getEmployeeId();

						session.setAttribute("firstname", firstName);
						session.setAttribute("employeeId", employeeId);
						session.setAttribute("sessionId", session.getId());
						System.out.println("Session sttributes set for Employee..!!");
						modelAndView.setViewName("home");
					} 
				}
			}
			catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception in signin - employee");
				e.printStackTrace();
			}

		}

		//modelAndView.setViewName("home");
		return modelAndView;
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
			@RequestParam("userType") Integer userType,
			HttpSession session) {





		//		User user = new User();
		//		Developer developer = new Developer();
		//		Tester tester = new Tester();
		//
		//		if(userType == 0) {
		//			user.setIsTester(false);
		//			//developer.setFirstName(fname);
		//			//developer.setLastName(lname);
		//			//developer.setLinkedInUrl("test url");
		//		} else {
		//			user.setIsTester(true);
		//			//tester.setFirstName(fname);
		//			//tester.setLastName(lname);
		//			//tester.setLinkedInUrl("test url");
		//		}
		//		user.setUserName(email);
		//		user.setPassword(password);
		//		user.setDeveloper(developer);
		//		user.setTester(tester);
		//		user.setFirstName(fname);
		//		user.setLastName(lname);
		//		
		//		System.out.println("Signup started for" + user.getFirstName() );
		//		
		//		userFacade.createUser(user);
		//		
		//		session.setAttribute("user", userFacade.getUser(user.getUserName()));
		//		session.setAttribute("sessionId", session.getId());
		//		System.out.println("Signup completed for user" + user.getFirstName() );
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
