package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Buyer;
import com.example.request.BuyerLoginRequest;
import com.example.request.BuyerRequest;
import com.example.response.BuyerLoginResponse;
import com.example.response.BuyerResponse;
import com.example.service.BuyerLoginService;
import com.example.service.BuyerService;

@RestController
@RequestMapping("/buyer")
@CrossOrigin(origins="*")
public class BuyerController {
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private BuyerLoginService buyerLoginService;
	
	
	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody BuyerRequest buyerRequest){
		BuyerResponse buyerResponse=null;
		Buyer user=null;
		try{
			user=buyerService.createUserReq(buyerRequest);
			return ResponseEntity.of(Optional.of(new BuyerResponse(user))); 
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("User Already Exist",HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> LoginUser(@RequestBody BuyerLoginRequest buyerLoginRequest){
		Buyer user=null;
		BuyerLoginResponse loginResponse=null;
			user=buyerLoginService.LoginUser(buyerLoginRequest);
			if(user==null) {		
				return new ResponseEntity<>("User Not Found",HttpStatus.FORBIDDEN);
			}else {
			return ResponseEntity.status(HttpStatus.OK).body(new BuyerLoginResponse(user)); 
			}
	}	
	

}
