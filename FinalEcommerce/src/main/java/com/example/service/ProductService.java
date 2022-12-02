package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	
	public List<Product> getAllProduct(String location);
	
	public int deleteProduct(Long productId);
	
	public void updateProduct(Product product,Long productId);
	
	Optional<Product> findByProductId(Long productId);

	List<Product> getAllProduct();
}
