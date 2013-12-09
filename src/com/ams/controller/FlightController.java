package com.ams.controller;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Flight;
import com.domain.FlightTime;
import com.domain.Response;
import com.service.AuthenticationServiceProxy;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;
import com.service.FlightServiceProxy;

@Controller
public class FlightController {

	private static final String VIEW_NAME = "commonJsonView";
	FlightServiceProxy flightProxy = new FlightServiceProxy();

	@RequestMapping(value = "/searchFlight.htm", method = RequestMethod.GET)
	public ModelAndView showSearchFlight() {
		return new ModelAndView("search_flight");
	}
	
	@RequestMapping(value = "/searchFlights.htm", method = RequestMethod.POST)
	public ModelAndView searchFlight(@RequestParam("source") String source,
			@RequestParam("destination") String destination,
			@RequestParam("departDate") String departDate) {
		
		Flight[] flights = null;
		try {
			flights = flightProxy.searchFlight(source, destination, departDate);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("search_flight", "flights", flights);
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
		List<Flight> flight_list = null;
		if(flights != null)
		{
			flight_list = Arrays.asList(flights);
		}
		
		return new ModelAndView("ListFlight","arr_flights", flight_list);
	}
	
	@RequestMapping(value = "/UpdateFlight.htm", method = RequestMethod.POST)
	  public ModelAndView UpdateFlight(@RequestParam("flightId") Integer flightId) {
	    
		Flight flight = new Flight();
		String day = "";
		String time = "";
		// = new FlightTime();
		flightProxy.setEndpoint("http://localhost:8080/AMS/services/FlightService");
		Response response = null;
		try 
		{
			System.out.println("Flight ID "+ flightId);
			flight = flightProxy.getFlightById(flightId);
			if(flight == null)
			{
				System.out.println("Flight object retireved");
				FlightTime[] flightTime = flight.getFlightTime();
				day = flightTime[0].getFlightDay();
				time = flightTime[0].getFlightTime();
				response = new Response ("success");
			}
			else
			{
				System.out.println("No flights retrieved by the flight ID");
				response = new Response("failure");
			}
		} 
		catch (RemoteException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("flight", flight);
		mv.addObject("day", day);
		mv.addObject("time",time);
		return mv;
	}
	
	@RequestMapping(value = "/UpdateFlight.htm", method = RequestMethod.GET)
	public ModelAndView updateFlight() {
	
	return new ModelAndView("UpdateFlight");
}
	
}
