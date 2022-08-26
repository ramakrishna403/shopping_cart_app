package com.mindtree.shoppingcartapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shoppingcartapp.entity.Product;
import com.mindtree.shoppingcartapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Product> getALLProduct() {
		return productRepository.findAll();
	}

	public List<Product> searchProduct(String keyword) {
		if (keyword != null) {
			return productRepository.search(keyword.toLowerCase());
		}
		return null;
	}

	public Optional<Product> getAProduct(int key) {
		return productRepository.findById(key);
	}
}
