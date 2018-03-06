package com.metacube.shoppingcart.dao;

import java.util.List;

import com.metacube.shoppingcart.entity.ShoppingCartProduct;

// interface of basic functions
public interface BaseDao {
	public List<ShoppingCartProduct> getAllShoppingCartProducts();
	public status addShoppingProduct(ShoppingCartProduct p);
	public status deleteShoppingProduct(int id);
	public status updateShoppingProduct(int productId, int quantity);
}
