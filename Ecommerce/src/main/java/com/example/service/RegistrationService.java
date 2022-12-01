package com.example.service;

import com.example.model.Seller;
import com.example.request.SellerRequest;

public interface RegistrationService {
	public Seller createUserReq(SellerRequest sellerRequest);
	
}
