package com.example.service.Impl;

import java.util.Optional;

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

	@Override
	public Optional<Buyer> findbyBuyerId(Long buyerId) {
		// TODO Auto-generated method stub
		return buyerRepo.findById(buyerId);
		
	}

	@Override
	public Buyer getBuyerId(Long buyerId) throws Exception {
		  Optional<Buyer> optionalUser = buyerRepo.findById(buyerId);
	        if (!optionalUser.isPresent())
	            throw new Exception("User id is invalid " + buyerId);
	        return optionalUser.get();
	}



	
}
