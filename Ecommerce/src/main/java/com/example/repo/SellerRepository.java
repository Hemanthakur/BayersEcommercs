package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Long> {

	public Seller findByPhoneNumber(String phoneNumber);

	public Seller findOneByPhoneNumberAndPassword(String phoneNumber, String password);
	
	@Query(value="SELECT sellerId FROM Seller s where s.phoneNumber=?1")
	public int getSellerIdByPhoneNumber(String phoneNumber);
}
