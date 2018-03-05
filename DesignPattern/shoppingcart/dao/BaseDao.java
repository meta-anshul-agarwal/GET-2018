package com.metacube.shoppingcart.dao;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;

public interface BaseDao {
	public List<Product> getAll();
	public status addProduct(Product p);
}
