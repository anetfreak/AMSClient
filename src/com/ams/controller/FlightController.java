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

import com.domain.Flight;
import com.domain.FlightTime;
import com.domain.Location;
import com.domain.Response;
import com.service.FlightServiceProxy;

@Controller
public class FlightController {

	private static final String VIEW_NAME = "commonJsonView";
	FlightServiceProxy flightProxy = new FlightServiceProxy();

	@RequestMapping(value = "/searchFlight.htm", method = RequestMethod.GET)
	public ModelAndView showSearchFlight() {
		Location[] locations = null;
		try {
			flightProxy.setEndpoint("http://localhost:8080/AMS/services/FlightService");
			locations = flightProxy.getLocations();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ModelAndView("search_flight", "locations", Arrays.asList(locations));
	}

	@RequestMapping(value = "/searchFlights.htm", method = RequestMethod.POST)
	public ModelAndView searchFlight(@RequestParam("source") String source,
			@RequestParam("destination") String destination,
			@RequestParam("departDate") String departDate) {

		Flight[] flights = null;
		Location[] locations = null;
		try {
			flights = flightProxy.searchFlight(source, destination, departDate);
			locations = flightProxy.getLocations();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("search_flight");
		modelAndView.addObject("flights", flights);
		modelAndView.addObject("source", source);
		modelAndView.addObject("destination", destination);
		modelAndView.addObject("locations", Arrays.asList(locations));
		return modelAndView;
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
	
	/*
	@RequestMapping(value = "/ListFlight.htm", method = RequestMethod.POST)
	public ModelAndView showUpdatedFlights() {

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

		return new ModelAndView(VIEW_NAME,"arr_flights", flight_list);
	}
*/
	@RequestMapping(value = "/UpdateEachFlight/{flightId}.htm", method = RequestMethod.GET)
	public ModelAndView UpdateFlight(@PathVariable("flightId") int flightId) {

		Flight flight = new Flight();
		String day = "";
		String time = "";
		Location[] locations = null;
		// = new FlightTime();
		System.out.println("In method..!!");
		flightProxy.setEndpoint("http://localhost:8080/AMS/services/FlightService");
		Response response = null;
		try 
		{
			System.out.println("Flight ID "+ flightId);
			flight = flightProxy.getFlightById(flightId);
			locations = flightProxy.getLocations();
			System.out.println("Locations Retrieved..!!"+locations);
			
			if(flight != null)
			{
				System.out.println("Flight object retireved");
				System.out.println("Flight ID :" +flight.getFlightId());
				FlightTime[] flightTime = flight.getFlightTime();
				day = flightTime[0].getFlightDay();
				time = flightTime[0].getFlightTime();
				System.out.println("Day : "+day);
				System.out.println("Time : "+time);
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


		ModelAndView mv = new ModelAndView("UpdateFlight");
		mv.addObject("flight", flight);
		mv.addObject("day", day);
		mv.addObject("time",time);
		mv.addObject("result", response);
		mv.addObject("locations", Arrays.asList(locations));
		return mv;
	}

	
	@RequestMapping(value = "/UpdateFlight.htm", method = RequestMethod.GET)
	public ModelAndView updateFlightInfo() {

		return new ModelAndView("UpdateFlight");
	}

	@RequestMapping(value = "/UpdateEachFlight.htm", method = RequestMethod.POST)
	public ModelAndView updateEachFlightInfo(@RequestParam("flightId") int flightId,
			@RequestParam("airlineName") String airlineName,
			@RequestParam("flightNo") String flightNo,
			@RequestParam("source") String source,
			@RequestParam("destination") String destination,
			@RequestParam("day") String day,
			@RequestParam("time") String time,
			@RequestParam("seats") int seats) 
	{
		System.out.println("Came inside.. ");
		flightProxy.setEndpoint("http://localhost:8080/AMS/services/FlightService");
		Flight flight = new Flight();
		FlightTime flightTime = new FlightTime();
		Response response = null;
		flight.setFlightId(flightId);
		flight.setFlightNo(flightNo);
		flight.setAirlineName(airlineName);
		flight.setDestination(destination);
		flight.setNoOfSeats(seats);
		flight.setSource(source);
		flightTime.setFlightDay(day);
		flightTime.setFlightTime(time);
		FlightTime[] fTimes = new FlightTime[]{flightTime}; 
		flight.setFlightTime(fTimes);
				
		System.out.println("11111111111");
		try 
		{
			System.out.println("Inside post method of updateFLight");
			boolean b = flightProxy.updateFlight(flight);
			if(b)
			{
				System.out.println("Flight detail updated..!");
				response = new Response("success");
			}
			else
			{
				System.out.println("Unsuccess..!!");
				response = new Response("failure");
			}
		} 
		catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView(VIEW_NAME, "result", response);
	}
	
	
	@RequestMapping(value = "/UpdateFlights.htm", method = RequestMethod.POST)
	public ModelAndView UpdateFlight(@RequestParam("source") String source,
			@RequestParam("destination") String destination,
			@RequestParam("departDate") String departDate) {

		Flight[] flights = null;
		try {
			flights = flightProxy.searchFlight(source, destination, departDate);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return new ModelAndView("UpdateFlight", "flights", flights);
	}

}
