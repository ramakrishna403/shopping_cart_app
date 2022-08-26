package com.mindtree.shoppingcartapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcartapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
