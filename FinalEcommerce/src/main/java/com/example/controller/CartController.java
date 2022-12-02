package com.example.controller;

import java.net.URI;
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

import com.example.model.Buyer;
import com.example.model.Cart;
import com.example.model.Product;
import com.example.model.Seller;
import com.example.repo.BuyerRepository;
import com.example.repo.CartRepository;
import com.example.repo.ProductRepository;
import com.example.response.CartDto;
import com.example.response.CartResponse;
import com.example.service.BuyerService;
import com.example.service.CartService;
import com.example.service.ProductService;

@RestController
@CrossOrigin(origins="*")
public class CartController {

	@Autowired
	private CartService cartService;
	
	
	@Autowired 
	private BuyerService buyerService;
	
	@Autowired 
	private ProductService productService;
	
	
	@PostMapping("/addToCart/{buyerId}/{productId}")
	public  ResponseEntity<?> addToCart(@PathVariable Long buyerId,@PathVariable Long productId,@RequestBody Cart cart) throws Exception{
		Optional<Buyer> buyerOptional=buyerService.findbyBuyerId(buyerId);
		Optional<Product> productOptional=productService.findByProductId(productId);
		
		if(!buyerOptional.isPresent()) {
			throw new Exception("Buyer Not Found");
		}
		Buyer user=buyerOptional.get();
		Product product=productOptional.get();
		cart.setBuyer(user);
		cart.setProduct(product);
		cartService.addToCart(cart);
		URI location1=ServletUriComponentsBuilder.fromCurrentRequest().path("/{buyerId}/{productId}").buildAndExpand(cart.getCartId(),cart.getCartId()).toUri();
		
		return ResponseEntity.created(location1).body("Product Added to Cart Successfully");
	}
	

	@PutMapping("/update/{buyerId}/{productId}/{cartId}")
	public ResponseEntity<?> updateStudent(@RequestBody Cart cart,@PathVariable Long buyerId,@PathVariable Long cartId,@PathVariable Long productId) throws Exception{
		Optional<Buyer> buyerOptional=buyerService.findbyBuyerId(buyerId);
		Optional<Product> productOptional=productService.findByProductId(productId);
		
		
		if(!buyerOptional.isPresent()) {
			throw new Exception("User Not Found");
		}
		try {
			Buyer user=buyerOptional.get();
			Product product=productOptional.get();
			cart.setBuyer(user);
			cart.setProduct(product);
			cartService.updateProductInCart(cart, cartId);
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{buyerId}/{productId}/{cartId}").buildAndExpand(cart.getCartId(),cart.getCartId(),cart.getCartId()).toUri();
			return ResponseEntity.created(location).body(" updtaed Successfully");
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
		}
	}
	
	@GetMapping("/cart/{buyerId}")
	public ResponseEntity<CartDto> getAllProductByBuyerId(@PathVariable Long buyerId) throws Exception{
		System.out.println("userdetails"+buyerId);
		Buyer buyer=buyerService.getBuyerId(buyerId);
		CartDto cartDto=cartService.listCartItem(buyer);
		return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
		}
	
	@DeleteMapping("/cart/delete/{cartId}")
	public ResponseEntity<?> deleteCartProduct(@PathVariable Long cartId){
		int val=cartService.deleteProductFromCart(cartId);
		return  ResponseEntity.status(HttpStatus.OK).body(val+" product deleted");
	}
	
	
}
