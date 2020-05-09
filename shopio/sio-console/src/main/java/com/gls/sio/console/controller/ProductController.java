package com.gls.sio.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gls.sio.product.model.Product;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String contactusPage(Model model) {
		model.addAttribute("product", new Product());
		return "productPage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOrUpdate(@ModelAttribute("product") Product product, BindingResult bindingResul) {
		System.out.println("ID: "+product.getId());
		System.out.println("Code: "+product.getCode());
		System.out.println("Name: "+product.getName());
		System.out.println("P1: "+product.getCostPrice());
		System.out.println("P2: "+product.getSellingPrice());
		return "productPage";
	}
}