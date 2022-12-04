package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.OrderItem;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer> {
}
