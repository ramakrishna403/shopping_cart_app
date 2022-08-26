package com.mindtree.shoppingcartapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shoppingcartapp.entity.User;
import com.mindtree.shoppingcartapp.service.UserService;

@RestController
@RequestMapping("api/v1/")
public class UserController {

	@Autowired
	private UserService userService;

	
	@GetMapping("/getAllUsers")
	public List<User> retriveAllUsers() {
		return userService.getAllActiveUsers();
	}

}
