package com.ams.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



import com.domain.Customer;
import com.domain.Employee;
import com.domain.Flight;
import com.domain.FlightTime;
import com.domain.Journey;
import com.domain.Location;
import com.domain.Person;
import com.domain.Reservation;
import com.domain.Traveller;
import com.service.AuthenticationServiceProxy;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;
import com.service.FlightServiceProxy;
import com.service.ReservationServiceProxy;



public class TestHarness {

	AuthenticationServiceProxy authProxy=new AuthenticationServiceProxy(); 
	CustomerServiceProxy custProxy = new CustomerServiceProxy();
	EmployeeServiceProxy empProxy = new EmployeeServiceProxy();
	FlightServiceProxy flightProxy = new FlightServiceProxy();
	ReservationServiceProxy reservationProxy = new ReservationServiceProxy();
	public TestHarness()
	{
		authProxy.setEndpoint("http://localhost:8080/AMS/services/AuthenticationService");
		custProxy.setEndpoint("http://localhost:8080/AMS/services/CustomerService");
		empProxy.setEndpoint("http://localhost:8080/AMS/services/EmployeeService");
		flightProxy.setEndpoint("http://localhost:8080/AMS/services/FlightService");
		reservationProxy.setEndpoint("http://localhost:8080/AMS/services/ReservationService");
	}
	/*This function generated an array of random numbers which are unique and are between 1 and 5000*/
	public List<Integer> randomNumberGenerator(int startInt, int endInt)
	{
		List<Integer> arrOfInt = new ArrayList<Integer>();
		for (int i = startInt; i < endInt; i++) {
			arrOfInt.add(i);
		}
		//shuffling the values
		Collections.shuffle(arrOfInt);
		return arrOfInt;
	}

	public boolean testingCustomerCreation()
	{

		List<Integer> arrOfInt = randomNumberGenerator(0,5000);
		List<Customer> custList = new ArrayList<Customer>();
		int customerId;
		//PDBConnection dbcon = new PDBConnection();
		for(int i=0 ; i<5000 ; i++)
		{
			customerId = arrOfInt.get(i);
			Customer customer = createCustomer(customerId);
			try {
				if(authProxy.customerSignUp(customer)!=0)
				{
					custList.add(customer);
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(custList.size() == 5000)
			return true;
		else 
			return false;
	}

	/* this function tests the creation of 
	 * approximately 5000 employees 
	 */
	public boolean testingEmployeeCreation()
	{
		List<Integer> arrOfInt = randomNumberGenerator(5000,10000);
		List<Employee> empList = new ArrayList<Employee>();
		int empId;
		//PDBConnection dbcon = new PDBConnection();
		for(int i=0 ; i<5000 ; i++)
		{
			empId = arrOfInt.get(i);

			Employee emp = createEmployee(empId);
			try {
				if(authProxy.employeeSignUp(emp)!=0)
					empList.add(emp);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(empList.size() == 5000)
			return true;
		else 
			return false;

	}

	/* This function tests the creation of 10,000 flights
	 * 
	 */
	public boolean testingFlightCreation()
	{	
		//PDBConnection dbcon = new PDBConnection();
		Location[] locations = null; 
		Random rnd = new Random();
		try {
			locations = flightProxy.getLocations();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(locations == null)
		{
			System.out.println("locations empty");
			return false;
		}
		List<Integer> arrOfInt = randomNumberGenerator(10000,11000);
		Flight flight;

		boolean bool = true;

		for(int i=0; i<1000; i++){
			flight = new Flight();
			flight.setFlightId(arrOfInt.get(i));
			flight.setFlightNo("AF"+i);

			int lr = rnd.nextInt(locations.length-1);
			flight.setSource(locations[lr].getAirportCode());
			int lr1 = rnd.nextInt(locations.length-1);
			if(lr == lr1)
				lr1 = rnd.nextInt(locations.length-1);
			flight.setDestination(locations[lr1].getAirportCode());
			flight.setNoOfSeats(100);
			flight.setAirlineName("AMS");

			FlightTime[] flightTime = new FlightTime[3];
			for(int j =0; j<3; j++)
			{

				int r = rnd.nextInt(6);
				String day = "";
				switch(r){
				case 0 : day="sun" ; break;
				case 1 : day="mon" ; break;
				case 2 : day="tue" ; break;
				case 3 : day="wed" ; break;
				case 4 : day="thu" ; break;
				case 5 : day="fri" ; break;
				case 6 : day="sat" ; break;
				}
				flightTime[j] = new FlightTime();
				flightTime[j].setFlightDay(day);
				flightTime[j].setFlightTime("0"+i+":00:00");
			}

			flight.setFlightTime(flightTime);
			try {
				bool = flightProxy.insertFlight(flight);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}

	public boolean testingReservationCreation()/****** currently not working*/
	{
		List<Integer> arrOfInt = randomNumberGenerator(20000,30000);
		Reservation reservation;
		Traveller []traveller = new Traveller[3];
		//PDBConnection dbcon = new PDBConnection(); 
		Journey []journey = new Journey[1];
		int customerId;
		for(int j=0; j<3; j++)
		{
			traveller[j] = new Traveller();
			traveller[j].setAge(30);
			traveller[j].setFirstName("Kanika");
			traveller[j].setLastName("anand");
			traveller[j].setSex("F");
			//			traveller[j].setTravellerId();
		}
		for(int k=0; k<1; k++)
		{
			journey[k] = new Journey();
			journey[k].setSource("SJC");
			journey[k].setDestination("AUS");
			journey[k].setFlightId(1);
			journey[k].setDateTime("09:00:00");

		}
		int count = 0;
		for(int i=0; i<1000; i++)
		{
			customerId = i-10000;
			reservation = new Reservation();
			reservation.setCustomerId(customerId);
			reservation.setReservationId(arrOfInt.get(i));
			reservation.setReservationNo("anynumber");
			reservation.setReservationStatus(1);
			reservation.setSeatsBooked(2);
			reservation.setTravellers(traveller);
			reservation.setJourney(journey);
			try {
				if(reservationProxy.insertReservation(reservation))
					count++;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(count == 1000)
			return true;
		else 
			return false;
	}


	/*********** CUSTOMER SERVICE TEST CASES****************/
	public boolean testGetCustomers()
	{

		Customer [] cust_list = null;
		//PDBConnection dbcon = new PDBConnection();
		try {
			cust_list = custProxy.getCustomers();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cust_list.length !=0)
		{
			return true;
		}
		return false;
	}
	public boolean testGetCustomer(int customerId)
	{
		//PDBConnection dbcon = new PDBConnection();
		Customer customer = null;
		try {
			customer = custProxy.getCustomer(customerId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(customer !=null)
		{
			return true;
		}
		return false;
	}

	public boolean testRetriveCustomerBypId(int personId)
	{
		//PDBConnection dbcon = new PDBConnection();
		Customer customer = null;
		try {
			customer = custProxy.retriveCustomerbypId(personId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(customer !=null)
		{
			return true;
		}
		return false;
	}
	public boolean testUpdateCustomer()
	{
		//PDBConnection dbcon = new PDBConnection();
		Customer customer = null;
		try {
			customer = custProxy.getCustomer(10);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(custProxy.updateCustomer(customer))
				return true;
			else 
				return false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	/****************EMPLOEE SERVICE TEST CASES*******************/
	public boolean testGetEmployees()
	{
		Employee [] emp_list =null ;
		//PDBConnection dbcon = new PDBConnection();
		try {
			emp_list = empProxy.getEmployees();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(emp_list.length !=0)
		{
			return true;
		}
		return false;
	}
	public boolean testGetEmployee(int employeeId)
	{
		//PDBConnection dbcon = new PDBConnection();
		Employee employee = null;
		try {
			employee = empProxy.getEmployee(employeeId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(employee !=null)
		{
			return true;
		}
		return false;
	}

	public boolean testRetriveEmployeeBypId(int personId)
	{
		//PDBConnection dbcon = new PDBConnection();
		Employee employee = null;
		try {
			employee = empProxy.retriveEmployeebypId(personId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(employee !=null)
		{
			return true;
		}
		return false;
	}
	public boolean testUpdateEmployee(Employee employee)
	{
		//PDBConnection dbcon = new PDBConnection();
		try {
			if(empProxy.updateEmployee(employee))
				return true;
			else 
				return false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/*******************FLIGHT SERVICE TEST CASES***************/
	public boolean testGetFlightByNo(String flightNo)
	{
		//PDBConnection dbcon = new PDBConnection();
		try {
			if(flightProxy.getFlightByNo(flightNo) != null)
				return  true;
			else 
				return false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
	public boolean testGetFlightById(int flightId)
	{
		//PDBConnection dbcon = new PDBConnection();
		try {
			if(flightProxy.getFlightById(flightId) != null)
				return true;
			else 
				return false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean testSearchFlight(String sourceAirport, String destAirport, String day){
		//PDBConnection dbcon = new PDBConnection();
		Flight[] flights = null;
		try {
			flights = flightProxy.searchFlight(sourceAirport, destAirport, day);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flights.length !=0)
			return true;
		else 
			return false;
	}
	public boolean testUpdateFlight(Flight flight)
	{
		//PDBConnection dbcon = new PDBConnection();
		try {
			if(flightProxy.updateFlight(flight))
				return true;
			else 
				return false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	/******************RESERVATION SERVICE TEST CASES**************/
	public boolean testGetReservations()
	{
		//PDBConnection dbcon = new PDBConnection();
		Reservation[] reservations = null;
		try {
			reservations = reservationProxy.getReservations();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(reservations.length != 0)
			return true;
		else 
			return false;
	}

	public boolean testGetReservation(int reservationId)
	{
		//PDBConnection dbcon = new PDBConnection();
		Reservation reservation = null;
		try {
			reservation = reservationProxy.getReservation(reservationId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (reservation != null)
			return true;
		else 
			return false;
	}
	public boolean testUpdateReservtion(Reservation reservation)
	{
		//PDBConnection dbcon = new PDBConnection();
		try {
			if(reservationProxy.updateReservation(reservation))
				return true;
			else 
				return false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public Customer createCustomer(int customerId)
	{

		Customer customer = new Customer();

		customer.setCustomerId(customerId);
		customer.setNationality("Indian");
		customer.setPassportNumber("AB1234JP");
		customer.setPerson(createPerson(++customerId));
		//customer.setReservation(null);
		return customer;

	}
	public Employee createEmployee(int employeeId)
	{
		Employee employee = new Employee();

		employee.setEmployeeId(employeeId);
		employee.setHireDate("10102010");
		employee.setPosition("Manager");
		employee.setWorkDesc("Manager");

		employee.setPerson(createPerson(++employeeId));
		return employee;

	}
	public Person createPerson(int personId)
	{
		Person person = new Person();
		//person.setPersonId(personId);
		person.setFirstName("Kanika");
		person.setLastName("Anand");
		person.setAddress("Metro Station");
		person.setCity("San Jose");
		person.setState("CA");
		person.setPersonType(1);
		person.setZip(95112);
		person.setUsername("user"+personId+"@gmai.com");
		person.setPassword("password");
		person.setDOB("101010");

		return person;
	}
	public static void main(String[] args) {
		TestHarness t = new TestHarness();
		//create 5000 customers

		if(args[0].equalsIgnoreCase("Create5000Customers"))
		{
			if(t.testingCustomerCreation())
			{
				System.out.println("5000 customers created");
			}
		}
		else if(args[0].equalsIgnoreCase("Create5000Employees"))
		{
			if(t.testingEmployeeCreation())
			{
				System.out.println("5000 employees created");
			}
		}
		else if(args[0].equalsIgnoreCase("Create1000Flights"))
		{
			if(t.testingFlightCreation())
			{
				System.out.println("1000 flights created");
			}
		}
		else if(args[0].equalsIgnoreCase("Create1000Reservations"))
		{
			if(t.testingReservationCreation())
			{
				System.out.println("1000 reservations created");
			}
		}
		else if(args[0].equalsIgnoreCase("GetCustomers"))
		{
			if(true == t.testGetCustomers())
			{
				System.out.println("Get Customers Successfull");
			}
		}
		else if(args[0].equalsIgnoreCase("GetCustomerByPersonId"))
		{
			if(true == t.testRetriveCustomerBypId(149760))
			{
				System.out.println("Get Customers Successfull");
			}
		}
		else if(args[0].equalsIgnoreCase("GetCustomerByCustId"))
		{
			if(true == t.testGetCustomer(10))
			{
				System.out.println("Get Customers Successfull");
			}
		}
		else if(args[0].equalsIgnoreCase("UpdateCustomer"))
		{
			
			if(true == t.testUpdateCustomer())
			{
				System.out.println("Update Customer Successfull");
			}
		}
		else if(args[0].equalsIgnoreCase("GetAllEmployees"))
		{
			
			if(true == t.testGetEmployees())
			{
				System.out.println("get employees Successfull");
			}
		}
		else if(args[0].equalsIgnoreCase("GetEmployeeById"))
		{
			
			if(true == t.testGetEmployee(56))
			{
				System.out.println("get employee Successfull");
			}
		}
		else if(args[0].equalsIgnoreCase("GetFlightById"))
		{
			
			if(true == t.testGetFlightById(100))
			{
				System.out.println("get Flight Successfull");
			}
		}
		else if(args[0].equalsIgnoreCase("GetAllReservations"))
		{
			
			if(true == t.testGetReservations())
			{
				System.out.println("get reservations Successfull");
			}
		}
	}
}

