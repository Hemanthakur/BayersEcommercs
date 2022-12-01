package com.example.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Cart;
import com.example.repo.BuyerRepository;
import com.example.repo.CartRepository;
import com.example.response.CartResponse;
import com.example.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	@Override
	public Cart addToCart(Cart cart) {
		// TODO Auto-generated method stub
		cart=cartRepository.save(cart);
		return cart;
	}

	


	@Override
	public void updateProductInCart(Cart cart, Long cartId) {
		// TODO Auto-generated method stub
		cart.setCartId(cartId);
		cartRepository.save(cart);
	}



	@Override
	public List<CartResponse> getAllProductByBuyerId(Long buyerId) {
		// TODO Auto-generated method stub
		List<CartResponse> li=cartRepository.getCartFromBuyer(buyerId);
		return li;
	}




	@Override
	public int deleteProductFromCart(Long cartId) {
		// TODO Auto-generated method stub
		int res=cartRepository.deleteByCartId(cartId);
		return res;
	}

}
