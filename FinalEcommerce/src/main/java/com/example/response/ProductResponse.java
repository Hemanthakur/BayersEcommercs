package com.example.response;

import com.example.model.Product;

import lombok.*;

@Getter
@Setter
public class ProductResponse {
	
	private Long productId;
	private String name;
	private String category;
	private int price;
	private int countInStock;
	private String description;
	private String location;
	
	public ProductResponse(Product product) {
		this.productId = product.getProductId();
		this.name = product.getName();
		this.category = product.getCategory();
		this.price = product.getPrice();
		this.countInStock = product.getCountInStock();
		this.description = product.getDescription();
		this.location=product.getLocation();
	}
	
	
	
}
