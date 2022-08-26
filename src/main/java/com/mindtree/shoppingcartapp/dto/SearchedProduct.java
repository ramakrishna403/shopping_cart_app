package com.mindtree.shoppingcartapp.dto;

import java.util.List;

import com.mindtree.shoppingcartapp.entity.Product;

import lombok.Data;

@Data

public class SearchedProduct {

	private String message;
	private List<Product> products;

	public SearchedProduct(String message, List<Product> products) {
		super();
		this.message = message;
		this.products = products;
	}
}
