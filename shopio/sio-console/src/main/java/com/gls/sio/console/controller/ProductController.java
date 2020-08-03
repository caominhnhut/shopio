package com.gls.sio.console.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gls.sio.console.validator.Errors;
import com.gls.sio.console.validator.RequestValidator;
import com.gls.sio.persistent.model.ProductRequest;
import com.gls.sio.product.model.Category;
import com.gls.sio.product.model.DataResponse;
import com.gls.sio.product.model.Product;
import com.gls.sio.product.service.ProductService;
import com.google.common.base.Strings;

@Controller
@RequestMapping(value = "/")
public class ProductController {

	private static final String PRODUCTS_VIEW = "listOfProductPage";
	private static final String CREATE_UPDATE_PRODUCT_VIEW = "createOrUpdateProductPage";

	@Autowired
	private ProductService productService;
	
	@Autowired
	private RequestValidator requestValidator;

	@RequestMapping(value = { "product", "product/list" }, method = RequestMethod.GET)
	public ModelAndView showProductsView() {
		
		ModelAndView modelAndView = new ModelAndView(PRODUCTS_VIEW);
		List<Product> products = productService.getProducts(new ProductRequest());
		modelAndView.addObject("products", products);
		
		return modelAndView;
	}

	@RequestMapping(value = { "product/save" }, method = RequestMethod.GET)
	public ModelAndView showCreateOrUpdateView() {
		
		ModelAndView modelView = new ModelAndView(CREATE_UPDATE_PRODUCT_VIEW);
		modelView.addObject("product", new Product());

		List<Category> categories = productService.getCategories();
		modelView.addObject("categories", categories);

		return modelView;
	}
	
	@RequestMapping(value = { "product/update" }, method = RequestMethod.GET)
	public ModelAndView showCreateOrUpdateView(@RequestParam("productId") Long productId) {

		ModelAndView modelView = new ModelAndView(CREATE_UPDATE_PRODUCT_VIEW);
		
		ProductRequest productRequest = new ProductRequest();
		productRequest.setId(productId);
		List<Product> products = productService.getProducts(productRequest);
		Product product = products.stream().findFirst().orElse(null);
		modelView.addObject("product", product);

		List<Category> categories = productService.getCategories();
		modelView.addObject("categories", categories);

		return modelView;
	}

	@RequestMapping(value = "product/save-or-update", method = RequestMethod.POST)
	public String saveOrUpdate(HttpServletRequest servletRequest, @ModelAttribute Product product, ModelMap model) {
		
		Errors errors = requestValidator.validateRequest(product);
		
		if (!errors.getErrors().isEmpty()) {			
			model.put("errorList", errors);
			
			List<Category> categories = productService.getCategories();
			model.put("categories", categories);
			
			return CREATE_UPDATE_PRODUCT_VIEW;
		}

		DataResponse<Product> dataResponse = productService.createOrUpdate(product);

		if (!Strings.isNullOrEmpty(dataResponse.getErrorMessage())) {
			model.put("errorMessage", dataResponse.getErrorMessage());
			return CREATE_UPDATE_PRODUCT_VIEW;
		}

		return "redirect:list";
	}
}