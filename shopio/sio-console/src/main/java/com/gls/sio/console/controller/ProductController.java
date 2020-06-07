package com.gls.sio.console.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gls.sio.product.model.DataResponse;
import com.gls.sio.product.model.Product;
import com.gls.sio.product.service.ProductService;
import com.google.common.base.Strings;

@Controller
@RequestMapping(value = "/")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = { "product", "product/list" }, method = RequestMethod.GET)
	public String showProductListPage(Model model) {
		model.addAttribute("product", new Product());
		return "listOfProductPage";
	}
	
	@RequestMapping(value = { "product/save-or-update"}, method = RequestMethod.GET)
	public String showCreateProductPage(Model model) {
//		Product p = new Product();
//		p.setCode("P123");
//		p.setName("XXX");
		model.addAttribute("product", new Product());
		return "createOrUpdateProductPage";
	}

	@RequestMapping(value = "product/save-or-update", method = RequestMethod.POST)
	public String saveOrUpdate(@ModelAttribute("product") Product product, BindingResult bindingResul, ModelMap model) {
		
		LOGGER.info(String.format("Saving product with product code: [%s]", product.getCode()));
		
		DataResponse<Product> dataResponse = productService.create(product);
		if(Strings.isNullOrEmpty(dataResponse.getErrorMessage()))
		{
			return "listOfProductPage";	
		}
		
		model.addAttribute("errorMessage", dataResponse.getErrorMessage());
		
		return "createOrUpdateProductPage";
	}
}