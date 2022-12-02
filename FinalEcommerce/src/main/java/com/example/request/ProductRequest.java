package com.example.request;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequest {
	
	private Long productId;
	private String name;
	private String category;
	private int price;
	private int countInStock;
	private String description;
	private String location;
}
