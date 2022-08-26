package com.mindtree.shoppingcartapp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private float price;
	
	private int qty;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Product> products;
	
	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
	private List<Quantity> quantity;
	

}
