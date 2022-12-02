package com.example.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.model.Product;
import com.example.model.Seller;
import com.example.repo.ProductRepository;
import com.example.repo.SellerRepository;
import com.example.request.ProductRequest;
import com.example.response.ProductResponse;
import com.example.service.ProductService;
import com.example.service.RegistrationService;


@RestController
@CrossOrigin(origins="*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired 
	private RegistrationService registerService;
	
	
	//To Add Product
	@PostMapping("/addProduct/{sellerId}")
	public ResponseEntity<?> addProduct(@PathVariable Long sellerId,@RequestBody Product product) throws Exception{
		Optional<Seller> sellerOptional=registerService.findBySellerId(sellerId);
		if(!sellerOptional.isPresent()) {
			throw new Exception("User Not Found");
		}
		Seller user=sellerOptional.get();
		product.setSeller(user);
		productService.addProduct(product);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{sellerId}").buildAndExpand(product.getProductId()).toUri();
		return ResponseEntity.created(location).body("Product Added Successfully");
	}
	
	//Get Products of Particular Seller
	@GetMapping("/products/{sellerId}")
	public ResponseEntity<List<Product>> getAllProductBySellerId(@PathVariable Long sellerId) throws Exception{
		Optional<Seller> sellerOptional=registerService.findBySellerId(sellerId);
		if(!sellerOptional.isPresent()) {
			throw new Exception("User Not Found");
		}	
		return   ResponseEntity.status(HttpStatus.CREATED).body(sellerOptional.get().getProducts());
	}
	
	@GetMapping("/products/loc/{location}")
	public ResponseEntity<List<Product>> getAllProductBylocation(@PathVariable String location){
		return   ResponseEntity.status(HttpStatus.CREATED).body(productService.getAllProduct(location));
	}
	
	
	//Find All Products
	@GetMapping("/products")
	public ResponseEntity<List<ProductResponse>> getAllProduct(){
		List<Product> li=productService.getAllProduct();
		List<ProductResponse> pl=new ArrayList<ProductResponse>();
		li.stream().forEach(product->{
		pl.add(new ProductResponse(product));	
		});
		
		if(li.size()<=0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return  ResponseEntity.status(HttpStatus.CREATED).body(pl); 
	}
	
	//Update a product
		@PutMapping("/{sellerId}/update/{productId}")
		public ResponseEntity<?> updateStudent(@RequestBody Product product,@PathVariable Long productId,@PathVariable Long sellerId) throws Exception{
			Optional<Seller> sellerOptional=registerService.findBySellerId(sellerId);
			if(!sellerOptional.isPresent()) {
				throw new Exception("User Not Found");
			}	
			try {
				Seller user=sellerOptional.get();
				product.setSeller(user);
				productService.updateProduct(product, productId);
				URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{sellerId}").buildAndExpand(product.getProductId()).toUri();
				return ResponseEntity.created(location).body("Product updtaed Successfully");
			}catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
			}
		}
	
	//Delete a Product
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
		int product=productService.deleteProduct(productId);
		return  ResponseEntity.status(HttpStatus.OK).body(product+" product deleted");
	}
	
	
}
