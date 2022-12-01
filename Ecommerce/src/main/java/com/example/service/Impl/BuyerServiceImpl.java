package com.example.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Buyer;
import com.example.repo.BuyerRepository;
import com.example.request.BuyerRequest;
import com.example.service.BuyerService;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private BuyerRepository buyerRepo;
	
	@Override
	public Buyer createUserReq(BuyerRequest buyerRequest) {
		Buyer user= new Buyer(buyerRequest);
	     user=buyerRepo.save(user);		
		return user; 	
	}
	
	public Buyer  findByPhoneNumber(String phoneNumber) {
		return buyerRepo.findByPhoneNumber(phoneNumber);
		
	}



	
}
