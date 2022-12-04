package com.example.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Buyer;
import com.example.model.Order;
import com.example.model.OrderItem;
import com.example.repo.OrderItemsRepository;
import com.example.repo.OrderRepository;
import com.example.request.PlaceOrderRequest;
import com.example.response.CartDto;
import com.example.response.CartItemDto;
import com.example.service.CartService;
import com.example.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
    private CartService cartService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;
    
    public void placeOrder(Buyer buyer, PlaceOrderRequest orderRequest) {
        // first let get cart items for the buyer
    	CartDto cartDto = cartService.listCartItem(buyer);

        List<CartItemDto> cartItemDtoList = cartDto.getcartItems();

        // create the order and save it
        Order newOrder = new Order();
        newOrder.setBuyer(buyer);
        newOrder.setAmount(cartDto.getTotalCost());
        newOrder.setAddress(orderRequest.getAddress());
        newOrder.setPaymentmethod(orderRequest.getPaymentmethod());
        newOrder.setPincode(orderRequest.getPincode());
        orderRepository.save(newOrder);

        for (CartItemDto cartItemDto : cartItemDtoList) {
            // create orderItem and save each one
            OrderItem orderItem = new OrderItem();
            orderItem.setPrice(cartItemDto.getProduct().getPrice());
            orderItem.setProduct(cartItemDto.getProduct());
            orderItem.setQuantity(cartItemDto.getQuantity());
            orderItem.setOrder(newOrder);
            // add to order item list
            orderItemsRepository.save(orderItem);
        }
        //
        cartService.deletebuyerCartItems(buyer);
    }

}
