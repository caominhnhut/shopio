package com.gls.sio.console.enums;

public enum ErrorCode {

	PRODUCT_CODE_ERROR("Product Code should not be empty"),
	PRODUCT_NAME_ERROR("Product Name should not be empty"),
	PRODUCT_CATEGORY_ERROR("Category should not be empty"),
	PRODUCT_COST_PRICE_ERROR("Cost price is incorrect"),
	PRODUCT_SELLING_PRICE_ERROR("Selling price is incorrect"),
	PRODUCT_IMAGE_ERROR("Product image should not be empty");
	
	private String errorMessage;
	
	private ErrorCode(String errorMessage) {
		this.errorMessage=errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
