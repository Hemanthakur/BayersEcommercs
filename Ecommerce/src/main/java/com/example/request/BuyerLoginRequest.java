package com.example.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyerLoginRequest {
	private String phoneNumber;
	private String password;
}
