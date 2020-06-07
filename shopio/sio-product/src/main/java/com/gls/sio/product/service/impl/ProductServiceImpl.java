package com.gls.sio.product.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.gls.sio.persistent.entity.ProductEntity;
import com.gls.sio.persistent.entity.UserEntity;
import com.gls.sio.persistent.exception.ShopIOException;
import com.gls.sio.persistent.repository.ProductRepository;
import com.gls.sio.product.mapper.Mapper;
import com.gls.sio.product.model.DataResponse;
import com.gls.sio.product.model.Product;
import com.gls.sio.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	
	private static final String SAVE_PRODUCT_ERROR_MESSAGE = "Cannot save product with product code: [%s]";

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private Mapper mapper;

	@Override
	public DataResponse<Product> create(Product product) {
		//TODO: Add category
		//TODO: show product list
		LOGGER.info(String.format("Saving product with product code [%s] to database", product.getCode()));
		
		DataResponse<Product> dataResponse = new DataResponse<Product>();
		
		UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ProductEntity productEntity = mapper.mapFromProduct(product);
		productEntity.setOwner(userEntity);
		
		try
		{
			ProductEntity createdProduct = productRepository.create(productEntity);
			product.setId(createdProduct.getId());
			dataResponse.setData(product);
		}
		catch (Exception e)
		{
			LOGGER.error(String.format(SAVE_PRODUCT_ERROR_MESSAGE, e.getMessage()));
			dataResponse.setErrorMessage(String.format(SAVE_PRODUCT_ERROR_MESSAGE, e.getMessage()));
		}

		return dataResponse;
	}
}
