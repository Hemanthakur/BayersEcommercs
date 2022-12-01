package com.example.response;

import com.example.model.Cart;
import com.example.model.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartResponse {
	private int quantity;
	private Product product;
	public CartResponse(Cart cart) {
		this.setQuantity(cart.getQuantity());
		this.setProduct(cart.getProduct());
	}
	
	
}
