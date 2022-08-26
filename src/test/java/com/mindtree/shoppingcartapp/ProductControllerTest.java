package com.mindtree.shoppingcartapp;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.mindtree.shoppingcartapp.entity.Product;
import com.mindtree.shoppingcartapp.service.ProductService;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

	@MockBean
	private ProductService productService;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Find Product by Id")
	void getAProductTest() throws Exception {
		
		Product mockProduct = new Product(2006,"Sweg shirt", 500);
		
		when(productService.getAProduct(2006)).thenReturn(Optional.of(mockProduct));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/{id}",2006))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	@DisplayName("Get All products Available")
	void getAllProductsTest() throws Exception {
		Product product1 = new Product(2003, "Let us C", 250);
		Product product2 = new Product(2004, "Java", 1100);
		
		List<Product> products = new ArrayList<Product>();
		products.add(product1);
		products.add(product2);
		
		when(productService.getALLProduct()).thenReturn(products);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$.[0].prodName", is("Let us C")));
	}

}
