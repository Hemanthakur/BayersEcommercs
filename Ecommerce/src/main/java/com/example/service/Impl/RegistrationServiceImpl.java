package com.example.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Seller;
import com.example.repo.SellerRepository;
import com.example.request.SellerRequest;
import com.example.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private SellerRepository sellerRepo;
	
	
	public Seller createUserReq(SellerRequest sellerRequest){
		Seller user=new Seller(sellerRequest);
		 user=sellerRepo.save(user);		
		return user; 	
	}
	
	
	public Seller  findByPhoneNumber(String phoneNumber) {
		return sellerRepo.findByPhoneNumber(phoneNumber);
	}


	@Override
	public Optional<Seller> findBySellerId(Long sellerId) {
		// TODO Auto-generated method stub
		return sellerRepo.findById(sellerId);
	}
}
