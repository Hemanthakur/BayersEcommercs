package com.example.response;

import com.example.model.Buyer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyerLoginResponse {

	private Long buyerId;	
	private String name;
	
	public BuyerLoginResponse(Buyer buyer) {
		this.buyerId = buyer.getBuyerId();
		this.name = buyer.getName();
	}
}