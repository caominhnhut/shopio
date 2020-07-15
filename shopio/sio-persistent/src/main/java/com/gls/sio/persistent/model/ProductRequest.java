package com.gls.sio.persistent.model;

public class ProductRequest {

	private String code;
	private String name;
	private Long costPriceFrom;
	private Long costPriceTo;
	private Long sellingPriceFrom;
	private Long sellingPriceTo;
	private String createdDateFrom;
	private String createdDateTo;
	private Long categoryId;
	private Long ownerId;
	private int limit;
	private int offset;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCostPriceFrom() {
		return costPriceFrom;
	}

	public void setCostPriceFrom(Long costPriceFrom) {
		this.costPriceFrom = costPriceFrom;
	}

	public Long getCostPriceTo() {
		return costPriceTo;
	}

	public void setCostPriceTo(Long costPriceTo) {
		this.costPriceTo = costPriceTo;
	}

	public Long getSellingPriceFrom() {
		return sellingPriceFrom;
	}

	public void setSellingPriceFrom(Long sellingPriceFrom) {
		this.sellingPriceFrom = sellingPriceFrom;
	}

	public Long getSellingPriceTo() {
		return sellingPriceTo;
	}

	public void setSellingPriceTo(Long sellingPriceTo) {
		this.sellingPriceTo = sellingPriceTo;
	}

	public String getCreatedDateFrom() {
		return createdDateFrom;
	}

	public void setCreatedDateFrom(String createdDateFrom) {
		this.createdDateFrom = createdDateFrom;
	}

	public String getCreatedDateTo() {
		return createdDateTo;
	}

	public void setCreatedDateTo(String createdDateTo) {
		this.createdDateTo = createdDateTo;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}
