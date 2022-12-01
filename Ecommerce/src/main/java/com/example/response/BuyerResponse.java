package com.example.response;

import com.example.model.Buyer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyerResponse {
	private Long buyerId;	
	private String name;
	private String phoneNumber;
	private String password;
	
	public BuyerResponse(Buyer buyer) {
		this.buyerId = buyer.getBuyerId();
		this.name = buyer.getName();
		this.phoneNumber = buyer.getPhoneNumber();
		this.password = buyer.getPassword();

}
}