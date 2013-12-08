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
//import com.service.FlightServiceProxy;

@Controller
public class AuthenticationController {

	private static final String VIEW_NAME = "commonJsonView";
	AuthenticationServiceProxy authProxy=new AuthenticationServiceProxy(); 
	CustomerServiceProxy custProxy = new CustomerServiceProxy();
	EmployeeServiceProxy empProxy = new EmployeeServiceProxy();
	//FlightServiceProxy flightProxy = new FlightServiceProxy();

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("userType") Integer userType,
			HttpSession session) {
		Response response = null;
		Customer customer = new Customer();

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
						System.out.println("Session attributes set for Employee..!!");
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
			@RequestParam("ssn") Integer ssn,
			@RequestParam("address") String address,
			@RequestParam("city") String city,
			@RequestParam("state") String state,
			@RequestParam("pincode") Integer pincode,
			@RequestParam("dob") String dob,
			@RequestParam(value="passport", required=false) String passport,
			@RequestParam(value="nationality", required=false) String nationality,
			@RequestParam(value="workdesc", required=false) String workdesc,
			@RequestParam(value="position", required=false) String position,
			@RequestParam(value="hiredate", required=false) String hiredate,
			@RequestParam("userType") Integer userType,
			HttpSession session) {

		authProxy.setEndpoint("http://localhost:8080/AMS/services/AuthenticationService");
		Employee employee = new Employee();
		Customer customer = new Customer();
		Person person = new Person();
		Response response = null; 
		
		person.setFirstName(fname);
		person.setLastName(lname);
		person.setAddress(address);
		person.setCity(city);
		person.setState(state);
		person.setZip(pincode);
		person.setDOB(dob);
		person.setUsername(email);
		person.setPassword(password);
		person.setPersonType(userType+1);
		
		int personId = -1;
		
		if(userType == 0)
		{
			System.out.println("You are an employee");
			
			try 
			{
				employee.setEmployeeId(ssn);
				employee.setHireDate(hiredate);
				employee.setPosition(position);
				employee.setWorkDesc(workdesc);
				employee.setPerson(person);
				
				personId = authProxy.employeeSignUp(employee);
				if(personId > 0)
				{
					System.out.println("Employee Created..!! PersonID : "+personId);
					response = new Response("success");
					session.setAttribute("person", person);
					session.setAttribute("employee", employee);
					
					Person p1 = (Person)session.getAttribute("person");
					System.out.println("First Name from session:"+ p1.getFirstName());
				}
				else
					response = new Response("failure");
			}
			catch (RemoteException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Exception in employee creation "+e);
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("You are a customer");
		
			try 
			{
				customer.setCustomerId(ssn);
				customer.setNationality(nationality);
				customer.setPassportNumber(passport);
				customer.setPerson(person);
				
				personId = authProxy.customerSignUp(customer);
				if (personId > 0)
				{
					System.out.println("Customer Created..!! Person ID : "+personId);
					response = new Response("success");
					session.setAttribute("person", person);
					session.setAttribute("customer", customer);
				}
				else
					response = new Response("failure");
			} 
			catch (RemoteException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Exception encountered in customer creation..!! "+e);
			}
		}

		return new ModelAndView(VIEW_NAME, "result", response);
	}

	
	@RequestMapping(value = "/EditProfile.htm", method = RequestMethod.GET)
	public ModelAndView showEditProfile(HttpSession session) {
		
		Response response = null;
		authProxy.setEndpoint("http://localhost:8080/AMS/services/AuthenticationService");
		
		Person person = new Person();
		person = (Person)session.getAttribute("person");
		System.out.println("Person ID : "+person.getPersonId());
		int personId = person.getPersonId();
		int userType = person.getPersonType();
		String fname = person.getFirstName();
		String lname = person.getLastName();
		String address = person.getAddress();
		String city = person.getCity();
		String state = person.getState();
		int zipCode = person.getZip();
		String dob = person.getDOB();
		String email = person.getUsername();
		String password	= person.getPassword();
						
		if(userType == 1){
			System.out.println("The logged in user is an Employee");
			Employee emp = (Employee)session.getAttribute("employee");
			int empId = emp.getEmployeeId();
			String hireDate = emp.getHireDate();
			String position = emp.getPosition();
			String workDesc = emp.getWorkDesc();
			int ssn = emp.getEmployeeId();
		}
		else{
			System.out.println("The logged in user is a customer");
		}
		
		return new ModelAndView("EditProfile");
	}
	
	@RequestMapping(value = "/EditProfile.htm", method = RequestMethod.POST)
	public ModelAndView editProfile(HttpSession session) {
		session.invalidate();
		return new ModelAndView("EditProfile");
	}

	

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("home");
	}
	
}
