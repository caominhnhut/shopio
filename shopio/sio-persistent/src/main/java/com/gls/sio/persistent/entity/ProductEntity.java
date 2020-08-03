package com.gls.sio.persistent.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@SequenceGenerator(name = "product_seq", initialValue = 1)
public class ProductEntity extends BaseTimestamp {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	private Long id;

	@Column(name="code", unique = true)
	private String code;

	@Column(name="name", unique = true)
	private String name;

	@Column(name="cost_price")
	private Long costPrice;

	@Column(name="selling_price")
	private Long sellingPrice;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private UserEntity owner;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FileEntity> files;
	
	public ProductEntity() {
		this.files = new HashSet<FileEntity>();
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

	public UserEntity getOwner() {
		return owner;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public Set<FileEntity> getFiles() {
		if(files == null)
		{
			files = new HashSet<FileEntity>();
		}
		
		return files;
	}

	public void setFiles(Set<FileEntity> files) {
		this.files = files;
	}

	public void setCostPrice(Long costPrice) {
		this.costPrice = costPrice;
	}

	public void setSellingPrice(Long sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
}
