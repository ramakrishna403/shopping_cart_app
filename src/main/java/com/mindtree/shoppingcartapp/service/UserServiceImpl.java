package com.mindtree.shoppingcartapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shoppingcartapp.entity.User;
import com.mindtree.shoppingcartapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;


	@Override
	public List<User> getAllActiveUsers() {
		return userRepository.findAll();
	}
}
