package com.ams.controller;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.AuthenticationServiceProxy;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;
import com.service.FlightServiceProxy;

import com.domain.Flight;
import com.domain.FlightTime;

@Controller
public class FlightController {

	private static final String VIEW_NAME = "commonJsonView";
	AuthenticationServiceProxy authProxy=new AuthenticationServiceProxy(); 
	CustomerServiceProxy custProxy = new CustomerServiceProxy();
	EmployeeServiceProxy empProxy = new EmployeeServiceProxy();
	FlightServiceProxy flightProxy = new FlightServiceProxy();

	@RequestMapping(value = "/searchFlight.htm", method = RequestMethod.GET)
	public ModelAndView showSearchFlight() {
		return new ModelAndView("search_flight");
	}
	
	@RequestMapping(value = "/searchFlights.htm", method = RequestMethod.POST)
	public ModelAndView searchFlight(@RequestParam("source") String source,
			@RequestParam("destination") String destination,
			@RequestParam("departDate") String departDate,
			@RequestParam("returnDate") String returnDate) {
		
		System.out.println("Source: " + source);
		System.out.println("Destination: " + destination);
		System.out.println("Depart Date: " + departDate);
		System.out.println("Return Date: " + returnDate);
		
		return new ModelAndView("search_flight");
	}
	
	@RequestMapping(value = "/ListFlight.htm", method = RequestMethod.GET)
		public ModelAndView showFlights() {
		
		Flight[] flights = null;
			
		flightProxy.setEndpoint("http://localhost:8080/AMS/services/FlightService");
		
		try {
			flights = flightProxy.getFlights();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		List<Flight> flight_list = Arrays.asList(flights);
		if(flight_list != null)
		{
			System.out.println("Size : "+ flight_list.size());
		}
		
		return new ModelAndView("ListFlight","arr_flights", flight_list);
	}
	
}
