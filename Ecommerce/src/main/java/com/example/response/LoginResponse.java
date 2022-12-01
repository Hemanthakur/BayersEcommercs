package com.example.response;

import com.example.model.Seller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

	private Long sellerId;	
	private String name;
	
	public LoginResponse(Seller seller) {
		this.sellerId = seller.getSellerId();
		this.name = seller.getName();
	}
	
	
}
