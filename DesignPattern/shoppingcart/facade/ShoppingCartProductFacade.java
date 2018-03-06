package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryDao;
import com.metacube.shoppingcart.dao.ProductFactory;
import com.metacube.shoppingcart.dao.db;
import com.metacube.shoppingcart.dao.status;
import com.metacube.shoppingcart.entity.ShoppingCartProduct;



public class ShoppingCartProductFacade {
	private static ShoppingCartProductFacade obj;
	
	BaseDao basedao =(InMemoryDao) ProductFactory.getInstance(db.InMemory);
	
	public static ShoppingCartProductFacade getInstance() {
		if (obj == null) {
			obj = new ShoppingCartProductFacade();
		}
		
		return obj;
	}
	
	private ShoppingCartProductFacade() {}
	
	
	public List<ShoppingCartProduct> getAllShoppingCartProducts(){
		return basedao.getAllShoppingCartProducts();
	}

	public status addProduct(ShoppingCartProduct product) {
		return basedao.addProduct(product);	
	}

	public status deleteShoppingProduct(int id) {
		// TODO Auto-generated method stub
		return basedao.deleteShoppingProduct(id);
	}

	public status updateShoppingProduct(int productId, int quantity) {
		// TODO Auto-generated method stub
		return basedao.updateShoppingProduct(productId , quantity);
	}
}
