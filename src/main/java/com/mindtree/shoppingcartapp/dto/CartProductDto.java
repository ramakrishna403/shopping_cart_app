package com.mindtree.shoppingcartapp.dto;

import com.mindtree.shoppingcartapp.entity.Product;

import lombok.Data;

@Data
public class CartProductDto {
	
	private Product product;
	private int quantity;
	public CartProductDto() {
		super();
	}
	public CartProductDto(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
