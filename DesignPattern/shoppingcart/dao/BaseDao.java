package com.metacube.shoppingcart.dao;

import java.util.List;

import com.metacube.shoppingcart.entity.ShoppingCartProduct;

public interface BaseDao {
	public List<ShoppingCartProduct> getAllShoppingCartProducts();
	public status addProduct(ShoppingCartProduct p);
	public status deleteShoppingProduct(int id);
	public status updateShoppingProduct(int productId, int quantity);
}
