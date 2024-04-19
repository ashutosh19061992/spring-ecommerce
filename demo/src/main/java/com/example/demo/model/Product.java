package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String productId;
	private String name;
	private Double price;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	
	private LocalDate dateOfManufacture;
	private String description;
	private Integer review;
	
	public Product() {
		
	}
	
	public Product(Integer id, String productId, String name, Double price, Category category,
			LocalDate dateOfManufacture, String description, Integer review) {
		super();
		Id = id;
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.category = category;
		this.dateOfManufacture = dateOfManufacture;
		this.description = description;
		this.review = review;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(LocalDate dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReview() {
		return review;
	}

	public void setReview(Integer review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Product [Id=" + Id + ", productId=" + productId + ", name=" + name + ", price=" + price + ", category="
				+ category + ", dateOfManufacture=" + dateOfManufacture + ", description=" + description + ", review="
				+ review + "]";
	}
}
