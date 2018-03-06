package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryDao;
import com.metacube.shoppingcart.dao.ProductFactory;
import com.metacube.shoppingcart.dao.db;
import com.metacube.shoppingcart.dao.status;
import com.metacube.shoppingcart.entity.ShoppingCartProduct;


// shopping cart products facade
public class ShoppingCartProductFacade {
	private static ShoppingCartProductFacade obj;
	
	// object of particular database 
	BaseDao basedao =(InMemoryDao) ProductFactory.getInstance(db.InMemory);
	
	// singleton object
	public static ShoppingCartProductFacade getInstance() {
		if (obj == null) {
			obj = new ShoppingCartProductFacade();
		}
		
		return obj;
	}
	
	private ShoppingCartProductFacade() {}
	
	// returns all shopping cart products
	public List<ShoppingCartProduct> getAllShoppingCartProducts(){
		return basedao.getAllShoppingCartProducts();
	}
	
	// adds product and return status
	public status addShoppingProduct(ShoppingCartProduct product) {
		return basedao.addShoppingProduct(product);	
	}

	// delete product from shopping cart and return status
	public status deleteShoppingProduct(int id) {
		return basedao.deleteShoppingProduct(id);
	}

	// update cart product
	public status updateShoppingProduct(int productId, int quantity) {
		return basedao.updateShoppingProduct(productId , quantity);
	}
}
