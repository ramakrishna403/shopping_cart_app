package com.mindtree.shoppingcartapp.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Book{

	private String genre;
	private String authour;
	private String publication;
	
	
	
	
}
