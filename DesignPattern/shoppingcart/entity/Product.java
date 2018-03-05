package com.metacube.shoppingcart.entity;

import java.util.UUID;

public class Product {
	private String id;
	private String name;
	private float price;
	
	public Product(String name, float price){
		this.name = name;
		this.price = price;
		UUID uuid = UUID.randomUUID();
		this.id = uuid.toString();
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
