package com.example.response;

import com.example.model.Seller;

import lombok.*;

@Getter
@Setter
public class SellerResponse {

	private Long sellerId;	
	private String name;
	private String phoneNumber;
	private String password;
	
	public SellerResponse(Seller seller) {
		this.sellerId = seller.getSellerId();
		this.name = seller.getName();
		this.phoneNumber = seller.getPhoneNumber();
		this.password = seller.getPassword();
	}


	
}
