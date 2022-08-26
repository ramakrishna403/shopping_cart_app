package com.mindtree.shoppingcartapp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	@JsonIgnore
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	private Cart cart;
	@CreationTimestamp
	@Column(name="create_at")
	private Date createAt;
	@UpdateTimestamp
	@Column(name="update_at")
	private Date updateAt;
	

	public User() {
		super();
	}

	public User(int id, String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public User(int id, String firstName, String lastName, int age, Cart cart) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.cart = cart;
	}


	

}
