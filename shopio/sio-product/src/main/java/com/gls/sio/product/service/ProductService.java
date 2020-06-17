package com.gls.sio.product.service;

import java.util.List;

import com.gls.sio.product.model.Category;
import com.gls.sio.product.model.DataResponse;
import com.gls.sio.product.model.Product;

public interface ProductService
{
	DataResponse create(Product product);
	
	List<Category> getCategories();
}
