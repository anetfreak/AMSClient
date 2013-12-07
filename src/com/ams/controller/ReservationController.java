package com.ams.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Customer;
import com.domain.Employee;
import com.domain.Flight;
import com.domain.FlightTime;
import com.domain.Person;
import com.service.AuthenticationServiceProxy;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;
import com.service.FlightServiceProxy;

@Controller
public class ReservationController {
  
  ReservationServiceProxy reservationProxy = new ReservationServiceProxy();
	
	@RequestMapping(value = "/ListReservations.htm", method = RequestMethod.GET)
	public ModelAndView showReservations() {
		
		Reservation[] reservation = null;

		custProxy.setEndpoint("http://localhost:8080/AMS/services/ReservationService");
		
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
		
		return new ModelAndView("ListCustomers","Reservations",reservations);
	}

}
