package com.gls.sio.product.service;

import java.util.List;

import com.gls.sio.persistent.model.ProductRequest;
import com.gls.sio.product.model.Category;
import com.gls.sio.product.model.DataResponse;
import com.gls.sio.product.model.Product;

public interface ProductService
{
	DataResponse<Product> create(Product product);
	
	List<Product> getProducts(ProductRequest productRequest);
	
	List<Category> getCategories();
}
