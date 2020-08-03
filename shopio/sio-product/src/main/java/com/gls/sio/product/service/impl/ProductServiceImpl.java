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
import com.gls.sio.persistent.model.ProductRequest;
import com.gls.sio.persistent.repository.CategoryRepository;
import com.gls.sio.persistent.repository.ProductRepository;
import com.gls.sio.product.mapper.Mapper;
import com.gls.sio.product.model.Category;
import com.gls.sio.product.model.DataResponse;
import com.gls.sio.product.model.Product;
import com.gls.sio.product.service.ProductService;
import com.google.common.base.Strings;

@Service
public class ProductServiceImpl implements ProductService {

	private Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	private static final String SAVE_PRODUCT_ERROR_MESSAGE = "Error when saving product with product code: [%s]. Please try again in 5 minutes";
	private static final String SAVE_PRODUCT_MESSAGE = "Saving product with product code [%s]";
	private static final String PRODUCT_PRICES_ERROR_MESSAGE = "The selling price must be greater than the cost price is 15.000";

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private FileService fileService;

	@Autowired
	private Mapper mapper;

	@Override
	public DataResponse<Product> createOrUpdate(Product product) {

		LOGGER.info(String.format(SAVE_PRODUCT_MESSAGE, product.getCode()));

		DataResponse<Product> dataResponse = new DataResponse<Product>();

		String validationResut = validateProduct(product);
		if (!Strings.isNullOrEmpty(validationResut)) {
			dataResponse.setErrorMessage(validationResut);
			return dataResponse;
		}

		try {
			if (product.getId() == null) {
				dataResponse.setData(create(product));
			} else {
				update(product);
				dataResponse.setData(product);
			}
		} catch (Exception e) {
			dataResponse.setErrorMessage(String.format(SAVE_PRODUCT_ERROR_MESSAGE, product.getCode()));
		}

		return dataResponse;
	}

	@Override
	public List<Category> getCategories() {

		List<CategoryEntity> categories = categoryRepository.findAll();

		return categories.stream().map(mapper::mapToCategory).collect(Collectors.toList());
	}

	@Override
	public List<Product> getProducts(ProductRequest productRequest) {

		List<ProductEntity> productEntities = productRepository.getProducts(productRequest);

		return productEntities.stream().map(mapper::mapFromProductEntity).collect(Collectors.toList());
	}

	private Product create(Product product) {

		ProductEntity productEntity = mapper.mapFromProduct(product);

		for (MultipartFile image : product.getImages()) {
			FileEntity fileEntity = fileService.storeFile(image);
			fileEntity.setProduct(productEntity);
		}

		UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		productEntity.setOwner(userEntity);

		CategoryEntity categoryEntity = categoryRepository.findOne(product.getCategory());
		productEntity.setCategory(categoryEntity);

		ProductEntity createdProduct = productRepository.create(productEntity);
		product.setId(createdProduct.getId());

		return product;
	}

	private void update(Product product) {

		ProductRequest productRequest = new ProductRequest();
		productRequest.setId(product.getId());
		ProductEntity updatedProduct = productRepository.getProducts(productRequest).get(0);

		updatedProduct = mapper.mapProductForUpdating(updatedProduct, product);

		if (updatedProduct.getCategory().getId() != product.getId()) {

			CategoryEntity categoryEntity = categoryRepository.findOne(product.getCategory());
			updatedProduct.setCategory(categoryEntity);
		}

		if (product.getFileDownloadUri().equals(updatedProduct.getFiles().stream().findFirst().get().getFileDownloadUri())) {

			productRepository.update(updatedProduct);
			return;
		}

		// Delete old image from directory
		fileService.detelePhysicalFile(updatedProduct.getFiles().stream().findFirst().get().getFileDownloadUri());

		// Store new image
		MultipartFile newImage = product.getImages().get(0);
		FileEntity fileEntity = fileService.storeFile(newImage);
		
		FileEntity updatedFileEntity = fileService.findByProductId(product.getId());
		updatedFileEntity.setFileDownloadUri(fileEntity.getFileDownloadUri());
		updatedFileEntity.setFilename(fileEntity.getFilename());
		updatedFileEntity.setFileType(fileEntity.getFileType());
		fileService.update(updatedFileEntity);

	}

	private String validateProduct(Product product) {

		if (product.getSellingPrice() - product.getCostPrice() < 15000) {
			return PRODUCT_PRICES_ERROR_MESSAGE;
		}

		return null;
	}
}
