package com.example.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartResponse {
	private String name;
	private String category;
	private int price;
	private int quantity;
	
	
}
