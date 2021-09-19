package com.simplilearn.shop;

import java.math.BigDecimal;
import java.util.List;
import java.util.StringJoiner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product")
public class Product {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	
	private String name;
	
	
	private double price;

	
	
	@OneToMany(cascade=CascadeType.ALL , mappedBy="product" )
	private List<ProductImage> images;
	
	

	public Product() {
		super();
	}

	public Product(String name, double price, List<ProductImage> images) {
		super();
		this.name = name;
		this.price = price;
		this.images = images;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public int getProductId() {
		return productId;
	}
	
	
	
	
	
	
	
	
	
}
