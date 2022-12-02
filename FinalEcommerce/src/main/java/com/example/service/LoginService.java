package com.example.service;

import com.example.model.Seller;
import com.example.request.LoginRequest;

public interface LoginService {

	public Seller LoginUser(LoginRequest loginRequest);
}
