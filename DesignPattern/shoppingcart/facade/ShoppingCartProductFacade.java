package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryShoppingCartDao;
import com.metacube.shoppingcart.dao.ProductFactory;
import com.metacube.shoppingcart.entity.ShoppingCartProduct;
import com.metacube.shoppingcart.enums.DBName;
import com.metacube.shoppingcart.enums.Status;


// shopping cart products facade
public class ShoppingCartProductFacade {
	private static ShoppingCartProductFacade shoppingCartProductFacade;
	
	// object of particular database 
	InMemoryShoppingCartDao inMemoryShoppingCartDao = (InMemoryShoppingCartDao) ProductFactory.getInstance(DBName.INMEMORY);
	
	// singleton object
	public static ShoppingCartProductFacade getInstance() {
		if (shoppingCartProductFacade == null) {
			shoppingCartProductFacade = new ShoppingCartProductFacade();
		}
		
		return shoppingCartProductFacade;
	}
	
	private ShoppingCartProductFacade() {}
	
	// returns all shopping cart products
	public List<ShoppingCartProduct> getAllShoppingCartProducts(){
		return inMemoryShoppingCartDao.getAllShoppingCartProducts();
	}
	
	// adds product and return status
	public Status addShoppingProduct(ShoppingCartProduct product) {
		return inMemoryShoppingCartDao.addShoppingProduct(product);	
	}

	// delete product from shopping cart and return status
	public Status deleteShoppingProduct(int id) {
		return inMemoryShoppingCartDao.deleteShoppingProduct(id);
	}

	// update cart product
	public Status updateShoppingProduct(int productId, int quantity) {
		return inMemoryShoppingCartDao.updateShoppingProduct(productId , quantity);
	}
}
