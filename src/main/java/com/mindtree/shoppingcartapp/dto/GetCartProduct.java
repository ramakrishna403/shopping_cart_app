package com.mindtree.shoppingcartapp.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetCartProduct {

	private List<CartProductDto> products;
	private float totalAmount ;
	
	public GetCartProduct( List<CartProductDto> products, float totalAmount) {
		super();
		this.products = products;
		this.totalAmount = totalAmount;
	}

	
	

}
