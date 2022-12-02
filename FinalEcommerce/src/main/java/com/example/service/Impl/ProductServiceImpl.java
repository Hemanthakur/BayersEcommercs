package com.example.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repo.ProductRepository;
import com.example.request.ProductRequest;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public Product addProduct(Product product) {
		product=productRepository.save(product); 
		return product;
	}


	@Override
	public List<Product> getAllProduct() {
		List<Product> li=productRepository.findAll();
		return li;
	}

	@Override
	public List<Product> getAllProduct(String location) {
		List<Product> li=productRepository.findAllByLocation(location);
		return li;
	}


	@Override
	public int deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		int product=productRepository.deleteByProductId(productId);
		return product;
	}


	@Override
	public void updateProduct(Product product, Long productId) {
		// TODO Auto-generated method stub
		product.setProductId(productId);
		productRepository.save(product); 
	}


	@Override
	public Optional<Product> findByProductId(Long productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

	
}
