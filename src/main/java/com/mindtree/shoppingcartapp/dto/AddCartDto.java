package com.mindtree.shoppingcartapp.dto;

import com.mindtree.shoppingcartapp.entity.Product;
import com.mindtree.shoppingcartapp.entity.User;

import lombok.Data;

@Data
public class AddCartDto {
	
	private Product product;
	private int quantity;
	private User user;
	
	public AddCartDto() {
		super();
	}

	public AddCartDto(Product product, int quantity, User user) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.user = user;
	}
	
	
}
