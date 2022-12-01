package com.example.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Buyer;
import com.example.model.Cart;
import com.example.repo.BuyerRepository;
import com.example.repo.CartRepository;
import com.example.response.CartDto;
import com.example.response.CartItemDto;
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
	public CartDto listCartItem(Buyer buyer) {
		// TODO Auto-generated method stub
		List<Cart> cartList=cartRepository.findAllByBuyerOrderByCartId(buyer);
		List<CartItemDto> cartItem=new ArrayList<>();
		for(Cart cart:cartList) {
			CartItemDto cartItemDto=getDtoFromCart(cart);
			cartItem.add(cartItemDto);
		}
		double total=0;
		for(CartItemDto cartItemDto:cartItem) {
			total+=(cartItemDto.getProduct().getPrice()*cartItemDto.getQuantity());
		}
		return new CartDto(cartItem,total);
	}

	public static CartItemDto getDtoFromCart(Cart cart) {
		return new CartItemDto(cart);
	}
//	@Override
//	public List<CartResponse> getAllProductByBuyerId(Long buyerId) {
//		// TODO Auto-generated method stub
//		List<CartResponse> li=(List<CartResponse>) cartRepository.getCartFromBuyer(buyerId);
//		return li;
//	}




	@Override
	public int deleteProductFromCart(Long cartId) {
		// TODO Auto-generated method stub
		int res=cartRepository.deleteByCartId(cartId);
		return res;
	}
	

}
