package com.ams.controller;

import java.rmi.RemoteException;
import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Customer;
import com.domain.Employee;
import com.domain.Location;
import com.domain.Person;
import com.domain.Response;
import com.service.AuthenticationServiceProxy;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;
//import com.service.FlightServiceProxy;
import com.service.FlightServiceProxy;

@Controller
public class AuthenticationController {

	private static final String VIEW_NAME = "commonJsonView";
	AuthenticationServiceProxy authProxy=new AuthenticationServiceProxy(); 
	CustomerServiceProxy custProxy = new CustomerServiceProxy();
	EmployeeServiceProxy empProxy = new EmployeeServiceProxy();
	FlightServiceProxy flightProxy = new FlightServiceProxy();

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
		Person person = new Person();

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
						person = customer.getPerson();

						session.setAttribute("firstname", firstName);
						session.setAttribute("customerId", customerId);
						session.setAttribute("sessionId", session.getId());
						session.setAttribute("personId", personId);
						session.setAttribute("person", person);
						session.setAttribute("customer", customer);

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
						person = employee.getPerson();

						session.setAttribute("firstname", firstName);
						session.setAttribute("employeeId", employeeId);
						session.setAttribute("sessionId", session.getId());
						session.setAttribute("personId", personId);
						session.setAttribute("person", person);
						session.setAttribute("employee", employee);
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


	@RequestMapping(value = "/adminLogin.htm", method = RequestMethod.POST)
	public ModelAndView adminLogin(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("userType") Integer userType,
			HttpSession session) 
	{
		Response response = null;

		if(userType == 99 && email.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase("admin")) {
			response = new Response("success");
			session.setAttribute("isAdmin", true);
			session.setAttribute("sessionId", session.getId());
		} else {
			response = new Response("failure");
		}
		return new ModelAndView(VIEW_NAME, "result", response);
	}

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/signup.htm", method = RequestMethod.GET)
	public ModelAndView showSignup() {
		Location[] locations = null;
		try {
			flightProxy.setEndpoint("http://localhost:8080/AMS/services/FlightService");
			locations = flightProxy.getLocations();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ModelAndView("signup", "locations", Arrays.asList(locations));
		//return new ModelAndView("signup");
	}

	@RequestMapping(value = "/signup.htm", method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam("fname") String fname, 
			@RequestParam("lname") String lname, 
			@RequestParam("email") String email,
			@RequestParam("password") String password, 
			@RequestParam("ssn") String ssn,
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
			@RequestParam(value="isUpdate", required=false) Boolean isUpdate,
			HttpSession session) {

		authProxy.setEndpoint("http://localhost:8080/AMS/services/AuthenticationService");
		Employee employee = new Employee();
		Customer customer = new Customer();
		Person person = new Person();
		Response response = null; 

		String combinedSSN = String.valueOf(ssn);
		if(!isUpdate)
		{
			String[] splitSSN = ssn.split("-");
			combinedSSN = splitSSN[0].concat(splitSSN[1]).concat(splitSSN[2]);
		}
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
				employee.setEmployeeId(Integer.valueOf(combinedSSN));
				employee.setHireDate(hiredate);
				employee.setPosition(position);
				employee.setWorkDesc(workdesc);
				employee.setPerson(person);

				if(!isUpdate)
				{
					personId = authProxy.employeeSignUp(employee);
					System.out.println("Entry not updated for employee");

					if(personId > 0)
					{
						System.out.println("Employee Created..!! PersonID : "+personId);
						response = new Response("success");
						session.setAttribute("person", person);
						session.setAttribute("employee", employee);
						session.setAttribute("personId", personId);
						session.setAttribute("firstname", person.getFirstName());
						session.setAttribute("sessionId", session.getId());
						Person p1 = (Person)session.getAttribute("person");
						System.out.println("First Name from session:"+ p1.getFirstName());
					}
					else
					{
						response = new Response("failure");
					}
				}
				else
				{
					personId = (Integer) session.getAttribute("personId");
					person.setPersonId(personId);
					boolean b =authProxy.updateEmpInformation(employee);
					if(b){

						//setting updated values in session
						session.setAttribute("person", person);
						session.setAttribute("employee", employee);
						session.setAttribute("personId", personId);
						session.setAttribute("firstname", person.getFirstName());
						session.setAttribute("sessionId", session.getId());

						response = new Response("updated");
						System.out.println("Employee table updated.");
						System.out.println("personID  = "+session.getAttribute("personId"));

					}
					else
					{
						response = new Response("updateFailed");
					}
				}
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
				customer.setCustomerId(Integer.valueOf(combinedSSN));
				customer.setNationality(nationality);
				customer.setPassportNumber(passport);
				customer.setPerson(person);

				if(!isUpdate)
				{
					personId = authProxy.customerSignUp(customer);
					System.out.println("New Entry added for customer");

					if (personId > 0)
					{
						System.out.println("Customer Created..!! Person ID : "+personId);
						response = new Response("success");
						session.setAttribute("person", person);
						session.setAttribute("personId", personId);
						session.setAttribute("firstname", person.getFirstName());
						session.setAttribute("sessionId", session.getId());
						session.setAttribute("customer", customer);
					}
					else
						response = new Response("failure");
				}
				else
				{
					personId = (Integer) session.getAttribute("personId");
					person.setPersonId(personId);
					boolean b =authProxy.updateCustInformation(customer);
					if(b)
					{
						//setting values in session
						session.setAttribute("person", person);
						session.setAttribute("personId", personId);
						session.setAttribute("firstname", person.getFirstName());
						session.setAttribute("sessionId", session.getId());
						session.setAttribute("customer", customer);
						response = new Response("updated");
						System.out.println("Customer table updated.");
						System.out.println("personID  = "+session.getAttribute("personId"));
					}
					else
					{
						response = new Response("updateFailed");
					}
				}
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


	@RequestMapping(value = "/EditProfile.htm", method = RequestMethod.POST)
	public ModelAndView showProfile(HttpSession session) {

		authProxy.setEndpoint("http://localhost:8080/AMS/services/AuthenticationService");
		flightProxy.setEndpoint("http://localhost:8080/AMS/services/FlightService");

		Response response = null;
		Person person = new Person();
		person = (Person) session.getAttribute("person");
		int personId = (Integer) session.getAttribute("personId");
		person.setPersonId(personId);
		int userType = person.getPersonType();

		response = new Response("failure");
		//ModelAndView modelview = new ModelAndView("EditProfile");

		Location[] locations = null;
		try 
		{
			locations = flightProxy.getLocations();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		if(userType == 1){
			System.out.println("The logged in user is an Employee");
			System.out.println("PersonId in session : "+personId);
			Employee emp = (Employee)session.getAttribute("employee");
			System.out.println("Employee ID "+ emp.getEmployeeId());
			emp.setPerson(person);
			response = new Response("success");
			//modelview.addObject("employee",emp);
			//modelview.addObject("person",emp.getPerson());

		}
		else{
			System.out.println("The logged in user is a customer");
			System.out.println("PersonId in session : "+personId);
			Customer customer = (Customer) session.getAttribute("customer");
			System.out.println("Customer ID : "+customer.getCustomerId());
			customer.setPerson(person);
			response = new Response("success");
			//modelview.addObject("customer",customer);
			//modelview.addObject("person",customer.getPerson());
		}

		ModelAndView modelView = new ModelAndView(VIEW_NAME);
		modelView.addObject("locations",Arrays.asList(locations));
		modelView.addObject("result",response);

		//return new ModelAndView(VIEW_NAME, "result", response);
		return modelView;
	}

	@RequestMapping(value = "/EditProfile.htm", method = RequestMethod.GET)
	public ModelAndView updateProfile() {
		Location[] locations = null;
		try {
			flightProxy.setEndpoint("http://localhost:8080/AMS/services/FlightService");
			locations = flightProxy.getLocations();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ModelAndView("EditProfile", "locations", Arrays.asList(locations));
		//return new ModelAndView("EditProfile");
	}

	@RequestMapping(value = "/ViewProfile.htm", method = RequestMethod.GET)
	public ModelAndView displayProfile() {
		return new ModelAndView("ViewProfile");
	}

}
