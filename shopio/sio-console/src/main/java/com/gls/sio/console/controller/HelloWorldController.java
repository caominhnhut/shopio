package com.gls.sio.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class HelloWorldController {
 
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "homePage";
    }
	
	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
    public String contactusPage(Model model) {
        model.addAttribute("name", "Vietnam");
        model.addAttribute("phone", "0123");
        model.addAttribute("email", "vi@gmail.com");
        return "productPage";
    }
	
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("greeting", "Hello Spring MVC");
        return "home";   
    }
}