package com.example.repo;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Buyer;
import com.example.model.Cart;
import com.example.response.CartResponse;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

	@Query(value="select p.name,p.category,p.price,c.quantity FROM Product p inner join Cart c on p.productId=c.product.productId where c.buyer.buyerId=?1")
	CartResponse getCartFromBuyer(Long buyerId);

	List<Cart> findAllByBuyerOrderByCartId(Buyer buyer);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM Cart Where cartId=?1")
	int deleteByCartId(Long cartId);

}
