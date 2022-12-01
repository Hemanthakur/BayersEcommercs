package com.example.response;

import com.example.model.Cart;
import com.example.model.Product;

import lombok.Data;

@Data
public class CartItemDto {

	 private Long cartId;
	    private  Integer quantity;
	    private  Product product;

	    public CartItemDto() {
	    }

	    public CartItemDto(Cart cart) {
	        this.setCartId(cart.getCartId());
	        this.setQuantity(cart.getQuantity());
	        this.setProduct(cart.getProduct());
	    }


}
