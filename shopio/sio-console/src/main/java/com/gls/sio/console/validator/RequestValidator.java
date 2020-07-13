package com.gls.sio.console.validator;

import org.springframework.stereotype.Component;

import com.gls.sio.console.enums.ErrorCode;
import com.gls.sio.product.model.Product;
import com.google.common.base.Strings;

@Component
public class RequestValidator {

	public Errors validateRequest(Product product) {
		Errors errors = new Errors();

		if (Strings.isNullOrEmpty(product.getCode())) {
			errors.getErrors().put(ErrorCode.PRODUCT_CODE_ERROR.name(), ErrorCode.PRODUCT_CODE_ERROR.getErrorMessage());
		}

		if (Strings.isNullOrEmpty(product.getName())) {
			errors.getErrors().put(ErrorCode.PRODUCT_NAME_ERROR.name(), ErrorCode.PRODUCT_NAME_ERROR.getErrorMessage());
		}

		if (product.getCategory() == 0) {
			errors.getErrors().put(ErrorCode.PRODUCT_CATEGORY_ERROR.name(),
					ErrorCode.PRODUCT_CATEGORY_ERROR.getErrorMessage());
		}

		if (product.getCostPrice() == 0) {
			errors.getErrors().put(ErrorCode.PRODUCT_COST_PRICE_ERROR.name(),
					ErrorCode.PRODUCT_COST_PRICE_ERROR.getErrorMessage());
		}

		if (product.getSellingPrice() == 0) {
			errors.getErrors().put(ErrorCode.PRODUCT_SELLING_PRICE_ERROR.name(),
					ErrorCode.PRODUCT_SELLING_PRICE_ERROR.getErrorMessage());
		}

		if (product.getImages() == null || product.getImages().isEmpty()) {
			errors.getErrors().put(ErrorCode.PRODUCT_IMAGE_ERROR.name(),
					ErrorCode.PRODUCT_IMAGE_ERROR.getErrorMessage());
		}

		return errors;
	}
}
