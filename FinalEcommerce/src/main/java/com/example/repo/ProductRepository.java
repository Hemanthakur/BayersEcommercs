package com.example.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Product;
import com.example.request.ProductRequest;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

	@Modifying
	@Transactional
	@Query(value="DELETE FROM Product Where productId=?1")
	int deleteByProductId(Long productId);

	List<Product> findAllByLocation(String location);
	
}
