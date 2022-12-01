package com.example.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.example.request.BuyerRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = "buyer",uniqueConstraints=@UniqueConstraint(
		columnNames="phoneNumber"
		) )
public class Buyer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long buyerId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String phoneNumber;
	
	@Column(nullable=false)
	private String password;

    public Buyer(BuyerRequest buyerRequest) {
	this.buyerId = buyerRequest.getBuyerId();
	this.name = buyerRequest.getName();
	this.phoneNumber = buyerRequest.getPhoneNumber();
	this.password = buyerRequest.getPassword();
	}
	
}
