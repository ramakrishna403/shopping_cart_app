package com.mindtree.shoppingcartapp.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shoppingcartapp.dto.AddCartDto;
import com.mindtree.shoppingcartapp.dto.GetCartProduct;
import com.mindtree.shoppingcartapp.dto.Message;
import com.mindtree.shoppingcartapp.service.CartService;

@RestController
@RequestMapping("api/v1/")
public class CartController {


	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart/{id}")
	public ResponseEntity<GetCartProduct> getCart(@PathVariable int id){
		try {
            return ResponseEntity.ok()
                    .location((new URI("/cart/"+id)))
                    .body(cartService.getAll(id));
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
		
	}
	
	@PostMapping("/cart")
	public ResponseEntity<Message> AddtoCart(@RequestBody AddCartDto cart) {
		
		try {
            return ResponseEntity.ok()
                    .location((new URI("/cart")))
                    .body(new Message(cartService.saveToCart(cart)));
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
		
	}
	
	@DeleteMapping("/cart")
	public ResponseEntity<Message> removeCart(@RequestBody AddCartDto cart) {
		
		try {
            return ResponseEntity.ok()
                    .location((new URI("/cart")))
                    .body(new Message(cartService.deletefromCart(cart)));
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

	}
	
	@PutMapping("/cart")
	public ResponseEntity<Message> updatingCart(@RequestBody AddCartDto cart) {
		try {
            return ResponseEntity.ok()
                    .location((new URI("/cart")))
                    .body(new Message(cartService.updatingCartProductQuantity(cart)));
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
}
