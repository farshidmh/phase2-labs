package com.simplilearn.shop;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product_image_meta")
public class ProductImageMeta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int metaId;
	
	
	private String metaKey;
	
	private String metaValue;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ProductImage productImage;

	
	
	public ProductImageMeta(String metaKey, String metaValue, ProductImage productImage) {
		super();
		this.metaKey = metaKey;
		this.metaValue = metaValue;
		this.productImage = productImage;
	}

	public ProductImageMeta() {
		super();
	}

	public String getMetaKey() {
		return metaKey;
	}

	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	public String getMetaValue() {
		return metaValue;
	}

	public void setMetaValue(String metaValue) {
		this.metaValue = metaValue;
	}

	public int getMetaId() {
		return metaId;
	}

	public ProductImage getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}
	
	
	
	
	

}
