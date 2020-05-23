package com.gls.sio.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class ApplicationController {
	
	@RequestMapping(value = {"home", "login"}, method = RequestMethod.GET)
	public String showHomePage() {
		return "loginPage";
	}

	@RequestMapping(value = "product", method = RequestMethod.GET)
	public String showProductPage() {
		return "productPage";
	}
	
	@RequestMapping(value = "access-denied", method = RequestMethod.GET)
	public String showAccessDeniedPage() {
		return "accessDeniedPage";
	}
}
