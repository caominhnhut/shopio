package com.gls.sio.console.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gls.sio.product.model.Category;
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
	public ModelAndView showCreateProductPage() {
		ModelAndView modelView = new ModelAndView("createOrUpdateProductPage");
		modelView.addObject("product", new Product());
		modelView.addObject("categories", Arrays.asList(new Category(1L, "Wooden Toy"), new Category(2L, "Plastic Toy"), new Category(3L, "Smart Toy")));
		return modelView;
	}

	@RequestMapping(value = "product/save-or-update", method = RequestMethod.POST)
	public String saveOrUpdate(@ModelAttribute Product product, BindingResult bindingResul, ModelMap model) {
		
		LOGGER.info(String.format("Saving product: [%s]", product));
		
		DataResponse<Product> dataResponse = productService.create(product);
		if(Strings.isNullOrEmpty(dataResponse.getErrorMessage()))
		{
			return "listOfProductPage";	
		}
		
		model.addAttribute("errorMessage", dataResponse.getErrorMessage());
		
		return "createOrUpdateProductPage";
	}
}