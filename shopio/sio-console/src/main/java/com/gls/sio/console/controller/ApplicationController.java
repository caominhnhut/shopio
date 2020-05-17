package com.gls.sio.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class ApplicationController {

	@RequestMapping(value = "/login-success", method = RequestMethod.GET)
	public String showLoginSuccess() {
		return "loginSuccess";
	}

	@RequestMapping(value = {"/login", "/logout"}, method = RequestMethod.GET)
	public String showLoginPage() {
		return "loginPage";
	}

	@RequestMapping(value = "/dba", method = RequestMethod.GET)
	public String showDBAPage() {
		return "dba";
	}
	
	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String showAccessDeniedPage() {
		return "accessDenied";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHomePage() {
		return "homePage";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String showProductPage() {
		return "productPage";
	}
}
