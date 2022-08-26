package com.mindtree.shoppingcartapp.entity;


import javax.persistence.*;

import org.springframework.lang.NonNull;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@NonNull
	private String productName;
	
	@NonNull
	private float productPrice;
	
	@Embedded
	private Book book;
	
	@Embedded
	private Apparal apparal;
	
	public Product() {
		super();
	}

	public Product(int productId, String prodName, float price) {
		super();
		this.productId = productId;
		this.productName = prodName;
		this.productPrice = price;
	}

	
	public Product(int productId, String prodName, float price, Book book) {
		super();
		this.productId = productId;
		this.productName = prodName;
		this.productPrice = price;
		this.book = book;
	}

	public Product(int productId, String prodName, float price, Book book, Apparal apparal) {
		super();
		this.productId = productId;
		this.productName = prodName;
		this.productPrice = price;
		this.book = book;
		this.apparal = apparal;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProdName() {
		return productName;
	}

	public void setProdName(String prodName) {
		this.productName = prodName;
	}

	public float getPrice() {
		return productPrice;
	}

	public void setPrice(float price) {
		this.productPrice = price;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Apparal getApparal() {
		return apparal;
	}

	public void setApparal(Apparal apparal) {
		this.apparal = apparal;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", productName='" + productName + '\'' +
				", productPrice=" + productPrice +
				", book=" + book +
				", apparal=" + apparal +
				'}';
	}
}

