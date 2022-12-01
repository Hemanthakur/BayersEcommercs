package com.example.service;

import java.util.Optional;

import com.example.model.Buyer;
import com.example.model.Cart;
import com.example.response.CartDto;

public interface CartService {

	public Cart addToCart(Cart cart);
	
	public CartDto listCartItem(Buyer buyer);
	
	public int deleteProductFromCart(Long cartId);
	
	public void updateProductInCart(Cart cart,Long cartId);

}
