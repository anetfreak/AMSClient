package com.ams.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Customer;
import com.domain.Flight;
import com.domain.Journey;
import com.domain.Reservation;
import com.domain.Traveller;
import com.service.AuthenticationServiceProxy;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;
import com.service.FlightServiceProxy;
import com.service.ReservationServiceProxy;

@Controller
public class TicketController {

	private static final String VIEW_NAME = "commonJsonView";
	AuthenticationServiceProxy authProxy=new AuthenticationServiceProxy(); 
	CustomerServiceProxy custProxy = new CustomerServiceProxy();
	EmployeeServiceProxy empProxy = new EmployeeServiceProxy();
	FlightServiceProxy flightProxy = new FlightServiceProxy();
	ReservationServiceProxy reservationProxy = new ReservationServiceProxy();

	@RequestMapping(value = "/issueTicket.htm", method = RequestMethod.GET)
	public ModelAndView issueTicket(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("issueTicket");
		mav.addObject("res", (Reservation) session.getAttribute("res"));
		return mav;
	}
	
	@RequestMapping(value = "/issueTicket.htm", method = RequestMethod.POST)
	public ModelAndView makeResv(@RequestParam("name") String name, 
			@RequestParam("card") String card,
			@RequestParam("cvv") Integer cvv,
			@RequestParam("expiryDate") String expiryDate,
			HttpSession session) {
		reservationProxy.setEndpoint("http://localhost:8080/AMS/services/ReservationService");
		
		Reservation res = new Reservation();
		Traveller trav1 = (Traveller) session.getAttribute("trav1");
		Traveller trav2 = (Traveller) session.getAttribute("trav2");
		Traveller trav3 = (Traveller) session.getAttribute("trav3");
		ArrayList<Traveller> travList = new ArrayList<Traveller>();
		travList.add(trav1);
		if(trav2 != null)
			travList.add(trav2);
		if(trav3 != null)
			travList.add(trav3);
		Traveller[] travArray = new Traveller[3];
		travList.toArray(travArray);
		res.setTravellers(travArray);
		
		res.setSeatsBooked(travList.size());
		Customer cust = (Customer) session.getAttribute("customer");
		res.setCustomerId(cust.getCustomerId());
		
		Flight flight1 = (Flight) session.getAttribute("flight1");
		Flight flight2 = (Flight) session.getAttribute("flight2");
		Journey journey1 = new Journey();
		journey1.setDateTime(flight1.getFlightTime()[0].getFlightTime());
		journey1.setDestination((flight1.getDestination()));
		journey1.setFlightId(flight1.getFlightId());
		journey1.setSource(flight1.getSource());
		Journey journey2 = new Journey();
		journey2.setDateTime(flight2.getFlightTime()[1].getFlightTime());
		journey2.setDestination((flight2.getDestination()));
		journey2.setFlightId(flight2.getFlightId());
		journey2.setSource(flight2.getSource());
		ArrayList<Journey> journeyList = new ArrayList<Journey>();
		journeyList.add(journey1);
		journeyList.add(journey2);
		
		Journey[] journeyArray = new Journey[2];
		journeyList.toArray(journeyArray);
		res.setJourney(journeyArray);
		res.setReservationStatus(1);
		
		try {
			reservationProxy.insertReservation(res);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		session.setAttribute("res", res);
		ModelAndView mav = new ModelAndView("issueTicket");
		return mav;
	}
	
	@RequestMapping(value = "/showPayment.htm", method = RequestMethod.GET)
	public ModelAndView showPayment() {
		return new ModelAndView("payment");
	}
	
	@RequestMapping(value = "/showPayment.htm", method = RequestMethod.POST)
	public ModelAndView savePass(@RequestParam("fname1") String fname1, 
			@RequestParam("lname1") String lname1,
			@RequestParam("age1") Integer age1,
			@RequestParam("gender1") String gender1,
			@RequestParam("fname2") String fname2, 
			@RequestParam("lname2") String lname2,
			@RequestParam("age2") Integer age2,
			@RequestParam("gender2") String gender2,
			@RequestParam("fname3") String fname3, 
			@RequestParam("lname3") String lname3,
			@RequestParam("age3") Integer age3,
			@RequestParam("gender3") String gender3, HttpSession session) {
		
		Traveller traveller1 = new Traveller();
		traveller1.setFirstName(fname1);
		traveller1.setLastName(lname1);
		traveller1.setAge(age1);
		traveller1.setSex(gender1);
		Traveller traveller2 = new Traveller();
		traveller2.setFirstName(fname2);
		traveller2.setLastName(lname2);
		traveller2.setAge(age2);
		traveller2.setSex(gender2);
		Traveller traveller3 = new Traveller();
		traveller3.setFirstName(fname3);
		traveller3.setLastName(lname3);
		traveller3.setAge(age3);
		traveller3.setSex(gender3);
		
		session.setAttribute("trav1", traveller1);
		session.setAttribute("trav2", traveller2);
		session.setAttribute("trav3", traveller3);
		return new ModelAndView("payment");
	}

}
