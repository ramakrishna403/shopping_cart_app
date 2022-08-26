package com.mindtree.shoppingcartapp;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.shoppingcartapp.dto.AddCartDto;
import com.mindtree.shoppingcartapp.dto.CartProductDto;
import com.mindtree.shoppingcartapp.dto.GetCartProduct;
import com.mindtree.shoppingcartapp.entity.Product;
import com.mindtree.shoppingcartapp.entity.User;
import com.mindtree.shoppingcartapp.service.CartService;

@SpringBootTest
@AutoConfigureMockMvc
class CartControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CartService cartService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Get List of items Added into your Cart")
	void getCartItems() throws Exception {
		Product product1 = new Product(2003, "Let us C", 250);
		Product product2 = new Product(2004, "Java", 1100);

		List<CartProductDto> list = new ArrayList<CartProductDto>();
		list.add(new CartProductDto(product1, 2));
		list.add(new CartProductDto(product2, 3));
		when(cartService.getAll(anyInt())).thenReturn(new GetCartProduct(list, 6000));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cart/{id}", 1001)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.products", hasSize(2)))
				.andExpect(jsonPath("$.products[0].product.prodName", is("Let us C")));

	}

	@Test
	@DisplayName("Adding Product into cart")
	void AddToCartTest() throws Exception {
		Product product = new Product(2003, "Let us C", 250);
		when(cartService.saveToCart(any())).thenReturn(product.getProdName() + " successfully added into your cart");

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/cart").content(CartControllerTest.asJsonString(product))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.message", is("Let us C successfully added into your cart")))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	@DisplayName("updating Quantity of products available into cart")
	void UpdatingCartProductTest() throws Exception {
		Product product = new Product(2003, "Let us C", 250);
		User user = new User(1001, "siva ramakrishna", "koppula", 21);
		AddCartDto cartDto = new AddCartDto(product, 5, user);
		when(cartService.updatingCartProductQuantity(any()))
				.thenReturn(product.getProdName() + " successfully updated into your cart");

		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/cart").content(CartControllerTest.asJsonString(cartDto))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.message", is("Let us C successfully updated into your cart")))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
