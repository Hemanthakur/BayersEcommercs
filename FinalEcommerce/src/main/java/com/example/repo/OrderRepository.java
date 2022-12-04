package com.example.repo;

import org.springframework.stereotype.Repository;

import com.example.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
