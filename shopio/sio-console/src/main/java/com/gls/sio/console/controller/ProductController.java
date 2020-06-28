package com.gls.sio.console.controller;

import java.util.List;

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

	@RequestMapping(value = { "product/save-or-update" }, method = RequestMethod.GET)
	public ModelAndView showCreateProductPage() {

		ModelAndView modelView = new ModelAndView("createOrUpdateProductPage");
		modelView.addObject("product", new Product());

		List<Category> categories = productService.getCategories();
		modelView.addObject("categories", categories);

		return modelView;
	}

	@RequestMapping(value = "product/save-or-update", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute Product product, BindingResult bindingResul, ModelMap model) {

		LOGGER.info(String.format("Saving product: [%s]", product));

		ModelAndView modelAndView = new ModelAndView("listOfProductPage");

		DataResponse<Product> dataResponse = productService.create(product);
		if (Strings.isNullOrEmpty(dataResponse.getErrorMessage())) {
			return modelAndView;
		}

		modelAndView.addObject("errorMessage", dataResponse.getErrorMessage());
		modelAndView.setViewName("createOrUpdateProductPage");

		return modelAndView;
	}
}