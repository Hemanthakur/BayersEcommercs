package com.example.service;

import java.util.List;

import com.example.model.Cart;
import com.example.response.CartResponse;

public interface CartService {

	public Cart addToCart(Cart cart);
	
	public List<CartResponse> getAllProductByBuyerId(Long buyerId);
	
	public int deleteProductFromCart(Long cartId);
	
	public void updateProductInCart(Cart cart,Long cartId);
}
