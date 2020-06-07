package com.gls.sio.product.service;

import com.gls.sio.product.model.DataResponse;
import com.gls.sio.product.model.Product;

public interface ProductService
{
	DataResponse create(Product product);
}
