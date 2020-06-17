package com.gls.sio.product.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	
	private Long id;
	private String code;
	private String name;
	private Long costPrice;
	private Long sellingPrice;
	private Long category;
	private List<MultipartFile> images;
	private Calendar createdDate;

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("\nid: ").append(this.id)
		.append("\ncode: ").append(this.code)
		.append("\nname: ").append(this.name)
		.append("\ncostPrice: ").append(this.costPrice)
		.append("\nsellingPrice: ").append(this.sellingPrice)
		.append("\ncategory: ").append(this.category)
		.append("\nimages: ").append(images.size());
		
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

	public Long getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Long costPrice) {
		this.costPrice = costPrice;
	}

	public Long getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Long sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
}
