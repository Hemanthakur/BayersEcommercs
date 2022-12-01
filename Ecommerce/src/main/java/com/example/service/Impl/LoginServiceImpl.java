package com.example.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Seller;
import com.example.repo.SellerRepository;
import com.example.request.LoginRequest;
import com.example.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SellerRepository sellerRepo;

	@Override
	public Seller LoginUser(LoginRequest loginRequest) {
		Seller user=new Seller();
		
		user=sellerRepo.findOneByPhoneNumberAndPassword(loginRequest.getPhoneNumber(),loginRequest.getPassword());
		return user;
	}


}
