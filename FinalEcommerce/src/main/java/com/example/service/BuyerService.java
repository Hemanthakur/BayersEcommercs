package com.example.service;

import java.util.Optional;

import com.example.model.Buyer;
import com.example.model.Cart;
import com.example.request.BuyerRequest;

public interface BuyerService {
	
	public Buyer createUserReq(BuyerRequest buyerRequest);
	
	Optional<Buyer> findbyBuyerId(Long buyerId);

	public Buyer getBuyerId(Long buyerId) throws Exception;
}
