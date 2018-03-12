package com.metacube.shoppingcart.dao;

import java.util.List;

import com.metacube.shoppingcart.entity.ShoppingCartProduct;
import com.metacube.shoppingcart.enums.Status;

// interface of basic functions
public interface BaseDao {
	public List<ShoppingCartProduct> getAllShoppingCartProducts();
	public Status addShoppingProduct(ShoppingCartProduct p);
	public Status deleteShoppingProduct(int id);
	public Status updateShoppingProduct(int productId, int quantity);
}
