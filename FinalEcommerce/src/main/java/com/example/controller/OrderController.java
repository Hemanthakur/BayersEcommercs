package com.example.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.model.Buyer;
import com.example.request.PlaceOrderRequest;
import com.example.service.BuyerService;
import com.example.service.OrderService;

@RestController
@RequestMapping("/checkout")
@CrossOrigin(origins="*")
public class OrderController {
	@Autowired 
	private BuyerService buyerService;
	
	@Autowired 
	private OrderService orderService;
	
	 @PostMapping("/{buyerId}")
	    public ResponseEntity<?> placeOrder(@PathVariable Long buyerId, @RequestBody PlaceOrderRequest orderRequest)
	            throws Exception {
	       
	        // retrieve buyer
		 	Optional<Buyer> buyerOptional=buyerService.findbyBuyerId(buyerId);
		 	if(!buyerOptional.isPresent()) {
				throw new Exception("Buyer Not Found");
			}
			Buyer user=buyerOptional.get();
	        // place the order
	        orderService.placeOrder(user,orderRequest);
	        URI location1=ServletUriComponentsBuilder.fromCurrentRequest().path("/{buyerId}").buildAndExpand(user.getBuyerId()).toUri();
	        return ResponseEntity.created(location1).body("Order has been placed");
	    }
}
