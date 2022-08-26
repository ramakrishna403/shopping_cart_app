package com.mindtree.shoppingcartapp.dto;

import lombok.Data;

@Data
public class Message {
	
	private String message;
	public Message() {
		super();
	}

	public Message(String message) {
		super();
		this.message = message;
	}

}
