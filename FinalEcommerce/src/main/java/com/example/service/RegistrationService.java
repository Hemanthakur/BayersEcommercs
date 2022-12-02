package com.example.service;

import java.util.Optional;

import com.example.model.Cart;
import com.example.model.Seller;
import com.example.request.SellerRequest;

public interface RegistrationService {
	public Seller createUserReq(SellerRequest sellerRequest);
	
	public Optional<Seller> findBySellerId(Long sellerId);
}
