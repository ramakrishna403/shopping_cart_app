package com.mindtree.shoppingcartapp.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shoppingcartapp.dto.SearchedProduct;
import com.mindtree.shoppingcartapp.entity.Product;
import com.mindtree.shoppingcartapp.service.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct(){
		try {
            return ResponseEntity.ok()
                    .location((new URI("/products")))
                    .body(productService.getALLProduct());
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@GetMapping("/search")
	public ResponseEntity<SearchedProduct> search(@Param("keyword") String keyword){
		
		try {
            return ResponseEntity.ok()
                    .location((new URI("/product?keyword="+keyword)))
                    .body(new SearchedProduct("Success", productService.searchProduct(keyword)));
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<?> getAProduct(@PathVariable int id) {
		
		return productService.getAProduct(id)
				.map(product -> {
					try {
						return ResponseEntity
						.ok()
						.location(new URI("/product/"+product.getProductId()))
						.body(product);
					}catch (URISyntaxException e) {
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
					}
				}).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("No, product Found with this id " + id));
		
	}

}
