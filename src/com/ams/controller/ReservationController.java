package com.ams.controller;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Reservation;
import com.service.ReservationServiceProxy;

@Controller
public class ReservationController {
  
  ReservationServiceProxy reservationProxy = new ReservationServiceProxy();
	
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
	@RequestMapping(value = "/ShowReservation.htm", method = RequestMethod.GET)
	public ModelAndView showReservation() {
		
		Reservation[] reservation = null;
		reservationProxy.setEndpoint("http://localhost:8080/AMS/services/ReservationService");
		
		try {
			reservation = reservationProxy.retriveReservationByCustId();
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
	@RequestMapping(value = "/AddTraveller.htm", method = RequestMethod.GET)
	  public ModelAndView AddTraveller() {
	    return new ModelAndView("AddTraveller");
	}

}
