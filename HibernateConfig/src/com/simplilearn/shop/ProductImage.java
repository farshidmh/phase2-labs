package com.simplilearn.shop;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product_image")
public class ProductImage {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int imageId;
	
	
	private String imageUrl;


	@ManyToOne(fetch=FetchType.LAZY)
	private Product product; 
	
	
	
	
	public ProductImage(String imageUrl) {
		super();
		this.imageUrl = imageUrl;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public int getImageId() {
		return imageId;
	}
	
	
	
	
	
	
	

}
