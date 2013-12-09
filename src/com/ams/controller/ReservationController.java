package com.ams.controller;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Customer;
import com.domain.Flight;
import com.domain.Reservation;
import com.service.FlightServiceProxy;
import com.domain.Response;
import com.service.ReservationServiceProxy;

@Controller
public class ReservationController {
  
  ReservationServiceProxy reservationProxy = new ReservationServiceProxy();
  FlightServiceProxy flightProxy = new FlightServiceProxy();
	
	@RequestMapping(value = "/ListReservations.htm", method = RequestMethod.GET)
	public ModelAndView showReservations() {
		
		Reservation[] reservation = null;
		reservationProxy.setEndpoint("http://localhost:8080/AMS/services/ReservationService");
		
		try {
			reservation = reservationProxy.getReservations();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Reservation> reservations = null;
		if(reservation != null)
		{
			reservations = Arrays.asList(reservation);
			//System.out.println("Size : "+ cust_list.size());
			//modelAndView.addObject("arr_flights", cust_list);
		}
		
		return new ModelAndView("ListReservations","Reservations",reservations);
	}

	@RequestMapping(value = "/AddTraveller.htm", method = RequestMethod.POST)
	  public ModelAndView AddTraveller(@RequestParam("flightId1") Integer flightId1, 
			  @RequestParam("flightId2") Integer flightId2, 
			  HttpSession session) {
		
		flightProxy.setEndpoint("http://localhost:8080/AMS/services/FlightService");
		Customer customer = (Customer) session.getAttribute("customer");
		Flight flight1 = null;
		Flight flight2 = null;
		try {
			flight1 = flightProxy.getFlightById(flightId1);
			flight2 = flightProxy.getFlightById(flightId2);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	    ModelAndView mav = new ModelAndView("AddTraveller");
	    session.setAttribute("flight1", flight1);
	    session.setAttribute("flight2", flight2);
	    return mav;
	    
	}
	
	@RequestMapping(value = "/ShowReservation.htm", method = RequestMethod.GET)
	public ModelAndView showReservation(HttpSession session) {
		
		Reservation[] reservation = null;
		reservationProxy.setEndpoint("http://localhost:8080/AMS/services/ReservationService");
		
		Integer custId = (Integer) session.getAttribute("customerId");
		try {
			reservation = reservationProxy.getReservationbyCustId(custId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Reservation> reservations = null;
		if(reservation != null)
		{
			reservations = Arrays.asList(reservation);
			//System.out.println("Size : "+ cust_list.size());
			//modelAndView.addObject("arr_flights", cust_list);
		}
		
		return new ModelAndView("ShowReservations","Reservations",reservations);
	}
	
	@RequestMapping(value = "/cancelReservation/{reservationId}.htm", method = RequestMethod.GET)
	public ModelAndView cancelReservation(@PathVariable("reservationId") int reservationId, HttpSession session) {

		reservationProxy.setEndpoint("http://localhost:8080/AMS/services/ReservationService");
		Response response = null;
		try 
		{
			System.out.println(reservationId);
			boolean b = reservationProxy.cancelReservation(reservationId);
			if(b)
			{
				System.out.println("Reservation Canceled.!!");
				response = new Response ("success");
			}
			else
			{
				System.out.println("Cant cancel Reservation..");
				response = new Response("failure");
			}
		} 
		catch (RemoteException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Function repeat..
		Reservation[] reservation = null;
		Integer custId = (Integer) session.getAttribute("customerId");
		try {
			reservation = reservationProxy.getReservationbyCustId(custId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Reservation> reservations = null;
		if(reservation != null)
		{
			reservations = Arrays.asList(reservation);
		}
		
		return new ModelAndView("ShowReservations","Reservations",reservations);
	}
	
	@RequestMapping(value = "/AddTraveller.htm", method = RequestMethod.GET)
	  public ModelAndView AddTraveller(HttpSession session) {
		return new ModelAndView("AddTraveller");
	}
}
