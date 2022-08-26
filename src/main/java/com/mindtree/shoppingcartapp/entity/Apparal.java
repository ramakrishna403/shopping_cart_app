package com.mindtree.shoppingcartapp.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Apparal {

	private String type;
	private String brand;
	private String design;

}
