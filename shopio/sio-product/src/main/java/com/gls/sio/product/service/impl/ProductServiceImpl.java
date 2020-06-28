package com.gls.sio.product.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gls.sio.file.service.FileService;
import com.gls.sio.persistent.entity.CategoryEntity;
import com.gls.sio.persistent.entity.FileEntity;
import com.gls.sio.persistent.entity.ProductEntity;
import com.gls.sio.persistent.entity.UserEntity;
import com.gls.sio.persistent.repository.CategoryRepository;
import com.gls.sio.persistent.repository.ProductRepository;
import com.gls.sio.product.mapper.Mapper;
import com.gls.sio.product.model.Category;
import com.gls.sio.product.model.DataResponse;
import com.gls.sio.product.model.Product;
import com.gls.sio.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	private static final String SAVE_PRODUCT_ERROR_MESSAGE = "Error when saving product with product code: [%s]. Please try again in 5 minutes";
	private static final String SAVE_PRODUCT_MESSAGE = "Saving product with product code [%s]";

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private FileService fileService;

	@Autowired
	private Mapper mapper;

	@Override
	public DataResponse<Product> create(Product product) {

		LOGGER.info(String.format(SAVE_PRODUCT_MESSAGE, product.getCode()));

		ProductEntity productEntity = mapper.mapFromProduct(product);

		for (MultipartFile image : product.getImages()) {
			FileEntity fileEntity = fileService.storeFile(image);
			fileEntity.setProduct(productEntity);
		}

		UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		productEntity.setOwner(userEntity);

		CategoryEntity categoryEntity = categoryRepository.findOne(product.getCategory());
		productEntity.setCategory(categoryEntity);

		DataResponse<Product> dataResponse = new DataResponse<Product>();

		try {

			ProductEntity createdProduct = productRepository.create(productEntity);
			product.setId(createdProduct.getId());
			dataResponse.setData(product);

		} catch (Exception e) {
			e.printStackTrace();
			dataResponse.setErrorMessage(String.format(SAVE_PRODUCT_ERROR_MESSAGE, product.getCode()));
		}

		return dataResponse;
	}

	@Override
	public List<Category> getCategories() {

		List<CategoryEntity> categories = categoryRepository.findAll();

		return categories.stream().map(mapper::mapToCategory).collect(Collectors.toList());
	}
}
