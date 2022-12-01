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

import com.example.model.Seller;
import com.example.request.LoginRequest;
import com.example.request.SellerRequest;
import com.example.response.LoginResponse;
import com.example.response.SellerResponse;
import com.example.service.LoginService;
import com.example.service.RegistrationService;

@RestController
@RequestMapping("/seller")
@CrossOrigin(origins="*")
public class SellerController {

	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/registerseller")
	public ResponseEntity<?> registerUser(@RequestBody SellerRequest sellerRequest){
		SellerResponse sellerResponse=null;
		Seller user=null;
		try{
			user=registrationService.createUserReq(sellerRequest);
			return ResponseEntity.of(Optional.of(new SellerResponse(user))); 
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("User Already Exist",HttpStatus.FORBIDDEN);
		}
	}
	
	
	@PostMapping("/loginseller")
	public ResponseEntity<?> LoginUser(@RequestBody LoginRequest loginRequest){
		Seller user=null;
		LoginResponse loginResponse=null;
			user=loginService.LoginUser(loginRequest);
			if(user==null) {		
				return new ResponseEntity<>("User Not Found",HttpStatus.FORBIDDEN);
			}else {
			return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse(user)); 
			}
	}
	
	
	
	
}
