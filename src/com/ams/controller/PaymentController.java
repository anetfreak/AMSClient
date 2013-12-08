package com.ams.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.service.AuthenticationServiceProxy;
import com.service.CustomerServiceProxy;
import com.service.EmployeeServiceProxy;
import com.service.FlightServiceProxy;

@Controller
public class PaymentController {

	private static final String VIEW_NAME = "commonJsonView";
	AuthenticationServiceProxy authProxy=new AuthenticationServiceProxy(); 
	CustomerServiceProxy custProxy = new CustomerServiceProxy();
	EmployeeServiceProxy empProxy = new EmployeeServiceProxy();
	FlightServiceProxy flightProxy = new FlightServiceProxy();

  @RequestMapping(value = "/payment.htm", method = RequestMethod.GET)
  public ModelAndView payment() {
	  Calendar cal = Calendar.getInstance();
	  long timeinMillis = cal.getTimeInMillis();
	  Date today = new Date(timeinMillis);
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return new ModelAndView("payment", "today", sdf.format(today));
  }

}
