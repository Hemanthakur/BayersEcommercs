package com.example.service;

import java.util.List;

import com.example.model.Product;
import com.example.request.ProductRequest;

public interface ProductService {
	
	public Product addProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public int deleteProduct(Long productId);
	
	public void updateProduct(Product product,Long productId);
	
}
