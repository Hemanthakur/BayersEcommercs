package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer,Long> {

	public Buyer findByPhoneNumber(String phoneNumber);
	
	public Buyer findOneByPhoneNumberAndPassword(String phoneNumber, String password);
	
	@Query(value="SELECT buyerId FROM Buyer b where b.phoneNumber=?1")
	public int getBuyerIdByPhoneNumber(String phoneNumber);
}