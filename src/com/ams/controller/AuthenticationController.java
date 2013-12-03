package com.ams.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("userType") Integer userType,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
			
		if(userType == 0)
			System.out.println("You are a Customer");
		else
			System.out.println("You are an Employee");
		session.setAttribute("firstname", "Chitra");
		session.setAttribute("sessionId", session.getId());
		modelAndView.setViewName("home");

		return modelAndView;
	}
	
	@RequestMapping(value = "/signup.htm", method = RequestMethod.GET)
	public ModelAndView showSignup() {
		return new ModelAndView("user_signup");
	}

//	@RequestMapping(value = "/signup.htm", method = RequestMethod.POST)
//	public ModelAndView signup(@RequestParam("fname") String fname, 
//			@RequestParam("lname") String lname, 
//			@RequestParam("email") String email,
//			@RequestParam("password") String password, 
//			@RequestParam("userType") Integer userType,
//			HttpSession session) {
//		
//		User user = new User();
//		Developer developer = new Developer();
//		Tester tester = new Tester();
//
//		if(userType == 0) {
//			user.setIsTester(false);
//			//developer.setFirstName(fname);
//			//developer.setLastName(lname);
//			//developer.setLinkedInUrl("test url");
//		} else {
//			user.setIsTester(true);
//			//tester.setFirstName(fname);
//			//tester.setLastName(lname);
//			//tester.setLinkedInUrl("test url");
//		}
//		user.setUserName(email);
//		user.setPassword(password);
//		user.setDeveloper(developer);
//		user.setTester(tester);
//		user.setFirstName(fname);
//		user.setLastName(lname);
//		
//		System.out.println("Signup started for" + user.getFirstName() );
//		
//		userFacade.createUser(user);
//		
//		session.setAttribute("user", userFacade.getUser(user.getUserName()));
//		session.setAttribute("sessionId", session.getId());
//		System.out.println("Signup completed for user" + user.getFirstName() );
//		return new ModelAndView("home");
//	}
	
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("home");
	}
	
//	@RequestMapping(value = "/checkUserRegistered.htm", method = RequestMethod.POST)
//	public ModelAndView checkUser(@RequestParam("email") String email, HttpSession session) {
//		Response response = null;
//		boolean exists = userFacade.checkInUser(email);
//		if(exists) {
//			response = new Response("exists");
//			User user = userFacade.getInUser(email);
//			session.setAttribute("user", user);
//			session.setAttribute("sessionId", session.getId());
//		} else {
//			response = new Response("newUser");
//		}
//		
//		return new ModelAndView(VIEW_NAME, "result", response);
//	}

}
