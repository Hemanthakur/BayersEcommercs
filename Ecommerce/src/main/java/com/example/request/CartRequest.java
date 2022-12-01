package com.example.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartRequest {

	private Long cartId;
	private int quantity;
}
