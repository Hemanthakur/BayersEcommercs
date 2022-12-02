package com.example.request;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerRequest {

	private Long sellerId;	
	@NotEmpty(message="Name cannot be empty")
	private String name;

	@NotEmpty(message="PhoneNumber cannot be empty")
	private String phoneNumber;
	
	@NotEmpty(message="Password cannot be empty")
	private String password;
	
	
}
