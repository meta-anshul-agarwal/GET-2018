package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.dao.ProductDao;
import com.metacube.shoppingcart.dao.db;
import com.metacube.shoppingcart.dao.status;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCartProduct;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.ShoppingCartProductFacade;

public class Controller {
	ShoppingCartProductFacade shoppingCartProductFacade = ShoppingCartProductFacade.getInstance();
	ProductFacade productFacade = ProductFacade.getInstance();
	private static Controller obj;
	
	public static Controller getInstance() {
		if (obj == null) {
			obj = new Controller();
		}
		
		return obj;
	}
	
	public status addProduct(ShoppingCartProduct product){
		return shoppingCartProductFacade.addProduct(product);
	}
	
	public List<ShoppingCartProduct> getAllShoppingCartProducts(){
		return shoppingCartProductFacade.getAllShoppingCartProducts();
	}
	
	public status productInitialization(){
		ProductDao productdao = ProductDao.getInstance();
		productdao.ProductInitialization();
		return status.Created;
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productFacade.getAllProducts();
	}

	public status deleteShoppingProduct(int id) {
		// TODO Auto-generated method stub
		return shoppingCartProductFacade.deleteShoppingProduct(id);
	}

	public status updateShoppingProduct(int productId, int quantity) {
		// TODO Auto-generated method stub
		return shoppingCartProductFacade.updateShoppingProduct(productId , quantity);
	}
}
