package com.gls.sio.console.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gls.sio.console.validator.Errors;
import com.gls.sio.console.validator.RequestValidator;
import com.gls.sio.product.model.Category;
import com.gls.sio.product.model.DataResponse;
import com.gls.sio.product.model.Product;
import com.gls.sio.product.service.ProductService;
import com.google.common.base.Strings;

@Controller
@RequestMapping(value = "/")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	private static final String PRODUCTS_VIEW = "listOfProductPage";
	private static final String CREATE_UPDATE_PRODUCT_VIEW = "createOrUpdateProductPage";

	@Autowired
	private ProductService productService;
	
	@Autowired
	private RequestValidator requestValidator;

	@RequestMapping(value = { "product", "product/list" }, method = RequestMethod.GET)
	public String showProductListPage(Model model) {
		
		model.addAttribute("product", new Product());
		
		return PRODUCTS_VIEW;
	}

	@RequestMapping(value = { "product/save-or-update" }, method = RequestMethod.GET)
	public ModelAndView showCreateProductPage() {

		ModelAndView modelView = new ModelAndView(CREATE_UPDATE_PRODUCT_VIEW);
		modelView.addObject("product", new Product());

		List<Category> categories = productService.getCategories();
		modelView.addObject("categories", categories);

		return modelView;
	}

	@RequestMapping(value = "product/save-or-update", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(HttpServletRequest servletRequest, @ModelAttribute Product product, ModelMap model) {

		LOGGER.info(String.format("Saving product: [%s]", product));

		ModelAndView modelAndView = new ModelAndView(CREATE_UPDATE_PRODUCT_VIEW);

		Errors errors = requestValidator.validateProduct(product);
		if (!errors.getErrors().isEmpty()) {			
			modelAndView.addObject("errorList", errors);
			
			List<Category> categories = productService.getCategories();
			modelAndView.addObject("categories", categories);
			
			return modelAndView;
		}

		DataResponse<Product> dataResponse = productService.create(product);

		if (!Strings.isNullOrEmpty(dataResponse.getErrorMessage())) {
			modelAndView.addObject("errorMessage", dataResponse.getErrorMessage());
			return modelAndView;
		}

		modelAndView.setViewName(PRODUCTS_VIEW);
		return modelAndView;
	}
}