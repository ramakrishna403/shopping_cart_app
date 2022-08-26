package com.mindtree.shoppingcartapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcartapp.entity.Cart;
import com.mindtree.shoppingcartapp.entity.User;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	Optional<Cart> findById(User user);
	Optional<Cart> findByUser(User user);

}
