package com.mindtree.shoppingcartapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcartapp.entity.Cart;
import com.mindtree.shoppingcartapp.entity.Product;
import com.mindtree.shoppingcartapp.entity.Quantity;
@Repository
public interface QuantityRepository extends JpaRepository<Quantity, Integer>{
	Optional<List<Quantity>> findByCart(Cart cart);
	Optional<Quantity> findByProduct(Product product);
}
