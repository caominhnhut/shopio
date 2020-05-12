package com.gls.sio.console.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gls.sio.product.model.Product;

@Controller
public class ProductController {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = { "/product/list" }, method = RequestMethod.GET)
	public String contactusPage(Model model) {
		model.addAttribute("product", new Product());
		return "productPage";
	}

	@RequestMapping(value = "/product/save", method = RequestMethod.POST)
	public String saveOrUpdate(@ModelAttribute("product") Product product, BindingResult bindingResul) {
		System.out.println("ID: " + product.getId());
		System.out.println("Code: " + product.getCode());
		System.out.println("Name: " + product.getName());
		System.out.println("P1: " + product.getCostPrice());
		System.out.println("P2: " + product.getSellingPrice());
		return "productPage";
	}
}