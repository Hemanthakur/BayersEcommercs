package com.example.service;

import com.example.model.Buyer;
import com.example.request.PlaceOrderRequest;

public interface OrderService {
	
	public void placeOrder(Buyer buyer,PlaceOrderRequest orderReques);
}
