package com.gls.sio.console.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gls.sio.product.model.Product;

@Controller
@RequestMapping(value = "/")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value = { "product", "product/list" }, method = RequestMethod.GET)
	public String showProductListPage(Model model) {
		model.addAttribute("product", new Product());
		return "listOfProductPage";
	}
	
	@RequestMapping(value = { "product/save-or-update"}, method = RequestMethod.GET)
	public String showCreateProductPage(Model model) {
		model.addAttribute("product", new Product());
		return "createOrUpdateProductPage";
	}

	@RequestMapping(value = "product/save-or-update", method = RequestMethod.POST)
	public String saveOrUpdate(@ModelAttribute("product") Product product, BindingResult bindingResul) {
		LOGGER.info("ID: "+product.getId());
		LOGGER.info("Code: "+product.getCode());
		LOGGER.info("Name: "+product.getName());
		LOGGER.info("P1: "+product.getCostPrice());
		LOGGER.info("P2: "+product.getSellingPrice());
		return "productPage";
	}
}