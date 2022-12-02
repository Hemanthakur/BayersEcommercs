package com.example.service;

import com.example.model.Buyer;
import com.example.request.BuyerLoginRequest;

public interface BuyerLoginService {
	public Buyer LoginUser(BuyerLoginRequest buyerLoginRequest);
}
