package com.mindtree.shoppingcartapp.service;

import com.mindtree.shoppingcartapp.dto.AddCartDto;
import com.mindtree.shoppingcartapp.dto.GetCartProduct;

public interface CartService  {

	public GetCartProduct getAll(int id);
	public String saveToCart(AddCartDto cartdto);
	public String deletefromCart(AddCartDto cartdto);
	public String updatingCartProductQuantity(AddCartDto cartdto);
}
