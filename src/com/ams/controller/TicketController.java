package com.ams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

}
