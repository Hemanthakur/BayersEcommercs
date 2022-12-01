package com.example.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.request.CartRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="cart")
public class Cart{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cartId;
	

	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	
	@ManyToOne(targetEntity=Buyer.class ,fetch=FetchType.EAGER)
	@JoinColumn(name="buyerId",nullable=false)
	@JsonIgnore
	private Buyer buyer;
	
	@Column(nullable=false)
	private int quantity;
	

	public Cart(CartRequest cartRequest) {
		this.cartId = cartRequest.getCartId();
		this.quantity = cartRequest.getQuantity();
	}

	public Cart(Product product, Buyer buyer, int quantity) {
		this.product = product;
		this.buyer = buyer;
		this.quantity = quantity;
	}
	
	
	
	
}
