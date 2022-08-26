package com.mindtree.shoppingcartapp.service;

import java.util.List;
import java.util.Optional;

import com.mindtree.shoppingcartapp.entity.Product;

public interface ProductService {
	public List<Product> getALLProduct();
	public List<Product> searchProduct(String keyword);
	public Optional<Product> getAProduct(int key);

}
