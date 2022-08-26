package com.mindtree.shoppingcartapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcartapp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.productName like %?1")
	Optional<List<Product>> findByProductName(String name);
	
	@Query("SELECT p FROM Product p WHERE CONCAT(LOWER(p.productId), LOWER(p.productName)) LIKE %?1%")
	public List<Product> search(String keyword);
}
