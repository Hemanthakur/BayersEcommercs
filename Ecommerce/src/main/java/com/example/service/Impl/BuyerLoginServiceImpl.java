package com.example.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Buyer;
import com.example.model.Seller;
import com.example.repo.BuyerRepository;
import com.example.request.BuyerLoginRequest;
import com.example.request.LoginRequest;
import com.example.service.BuyerLoginService;
import com.example.service.LoginService;

@Service
public class BuyerLoginServiceImpl implements BuyerLoginService {

		@Autowired
		private BuyerRepository buyerRepo;

		@Override
		public Buyer LoginUser(BuyerLoginRequest buyerLoginRequest) {
			Buyer user=new Buyer();
			
			user=buyerRepo.findOneByPhoneNumberAndPassword(buyerLoginRequest.getPhoneNumber(),buyerLoginRequest.getPassword());
			return user;
		}
	
}
