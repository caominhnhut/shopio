package com.gls.sio.product.mapper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.gls.sio.persistent.entity.CategoryEntity;
import com.gls.sio.persistent.entity.FileEntity;
import com.gls.sio.persistent.entity.ProductEntity;
import com.gls.sio.product.model.Category;
import com.gls.sio.product.model.Product;

@Component
public class Mapper {
	
	private static final String YYYY_MM_DD_TIME = "yyyy-MM-dd HH:mm:ss"; 

	public ProductEntity mapFromProduct(Product product) {

		ProductEntity productEntity = new ProductEntity();
		productEntity.setCode(product.getCode());
		productEntity.setName(product.getName());
		productEntity.setCostPrice(product.getCostPrice());
		productEntity.setSellingPrice(product.getSellingPrice());

		return productEntity;
	}

	public Category mapToCategory(CategoryEntity categoryEntity) {
		return new Category(categoryEntity.getId(), categoryEntity.getName());
	}

	public Product mapFromProductEntity(ProductEntity productEntity) {

		Product product = new Product();
		product.setId(productEntity.getId());
		product.setCode(productEntity.getCode());
		product.setName(productEntity.getName());
		product.setCostPrice(productEntity.getCostPrice());
		product.setSellingPrice(productEntity.getSellingPrice());
		product.setCreatedDate(formatDate(productEntity.getTimestampCreated()));
		product.setModifiedDate(formatDate(productEntity.getTimestampModified()));
		product.setCategory(productEntity.getCategory().getId());

		FileEntity fileEntity = productEntity.getFiles().stream().findFirst().orElseGet(null);
		
		product.setFileDownloadUri(fileEntity.getFileDownloadUri());

		return product;
	}

	public ProductEntity mapProductForUpdating(ProductEntity productEntity, Product product) {

		if(!product.getCode().equals(productEntity.getCode())) {
			productEntity.setCode(product.getCode());
		}
		
		if(!product.getName().equals(productEntity.getName())) {
			productEntity.setName(product.getName());
		}
		
		if(product.getCostPrice() != productEntity.getCostPrice()) {
			productEntity.setCostPrice(product.getCostPrice());
		}
		
		if(product.getSellingPrice() != productEntity.getSellingPrice()) {
			productEntity.setSellingPrice(product.getSellingPrice());
		}

		return productEntity;
	}
	
	private String formatDate(Calendar calendar) {
		
		Date date = calendar.getTime();		
		SimpleDateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD_TIME);
		return dateFormat.format(date);
	}
}
