package com.metacube.shoppingcart.entity;

import java.util.UUID;

public class ShoppingCartProduct extends BaseEntity{
	private int id;
	private int quantity;
	
	public ShoppingCartProduct(int id ,int quantity){
		this.id = id;
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

}
