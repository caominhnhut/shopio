package com.gls.sio.product.mapper;

import org.springframework.stereotype.Component;

import com.gls.sio.persistent.entity.ProductEntity;
import com.gls.sio.product.model.Product;

@Component
public class Mapper {

	public ProductEntity mapFromProduct(Product product) {
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setCode(product.getCode());
		productEntity.setName(product.getName());
		productEntity.setCostPrice(product.getCostPrice());
		productEntity.setSellingPrice(product.getSellingPrice());
		
		return productEntity;
	}
}
