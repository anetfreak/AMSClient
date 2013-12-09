package com.ams.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domain.Traveller;
import com.service.AuthenticationServiceProxy;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;
import com.service.FlightServiceProxy;

@Controller
public class TicketController {

	private static final String VIEW_NAME = "commonJsonView";
	AuthenticationServiceProxy authProxy=new AuthenticationServiceProxy(); 
	CustomerServiceProxy custProxy = new CustomerServiceProxy();
	EmployeeServiceProxy empProxy = new EmployeeServiceProxy();
	FlightServiceProxy flightProxy = new FlightServiceProxy();

	@RequestMapping(value = "/issueTicket.htm", method = RequestMethod.GET)
	public ModelAndView issueTicket() {
		return new ModelAndView("issueTicket");
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
