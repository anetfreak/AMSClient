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
		person.setPersonId(personId);
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
		/*if(t.testingCustomerCreation())
		{
			System.out.println("5000 customers created");
		}

		//create 5000 employees
		if(t.testingEmployeeCreation())
		{
			System.out.println("5000 employees created");
		}
		if(t.testingFlightCreation())
		{
			System.out.println("1000 flights created");
		}
		if(t.testingReservationCreation())
		{
			System.out.println("1000 flights created");
		}*/

	}

}
