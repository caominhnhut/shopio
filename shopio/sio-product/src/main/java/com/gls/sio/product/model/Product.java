package com.gls.sio.product.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Product {

	private Long id;
	private String code;
	private String name;
	private long costPrice;
	private long sellingPrice;
	private long category;
	private List<MultipartFile> images;
	private String createdDate;
	private String modifiedDate;
	private List<String> imageUris;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nid: ").append(this.id).append("\ncode: ").append(this.code).append("\nname: ")
				.append(this.name).append("\ncostPrice: ").append(this.costPrice).append("\nsellingPrice: ")
				.append(this.sellingPrice).append("\ncategory: ").append(this.category).append("\nimages: ")
				.append(images.size());

		return builder.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public long getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(long costPrice) {
		this.costPrice = costPrice;
	}

	public long getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(long sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	public List<String> getImageUris() {
		if (imageUris == null) {
			imageUris = new ArrayList<String>();
		}

		return imageUris;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
