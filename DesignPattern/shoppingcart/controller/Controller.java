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
	
	// singleton object
	public static Controller getInstance() {
		if (obj == null) {
			obj = new Controller();
		}
		
		return obj;
	}
	
	// calls facade for adding product
	public status addShoppingProduct(ShoppingCartProduct product){
		return shoppingCartProductFacade.addShoppingProduct(product);
	}
	
	// calls facade for fetching all shopping cart product list
	public List<ShoppingCartProduct> getAllShoppingCartProducts(){
		return shoppingCartProductFacade.getAllShoppingCartProducts();
	}
	
	// initialize product list
	public status productInitialization(){
		ProductDao productdao = ProductDao.getInstance();
		productdao.ProductInitialization();
		return status.Created;
	}

	// calls facade for fetching product list
	public List<Product> getAllProducts() {
		return productFacade.getAllProducts();
	}

	// calls facade for deleting product in shopping cart list
	public status deleteShoppingProduct(int id) {
		return shoppingCartProductFacade.deleteShoppingProduct(id);
	}

	// calls facade for updating product in shopping cart list
	public status updateShoppingProduct(int productId, int quantity) {
		return shoppingCartProductFacade.updateShoppingProduct(productId , quantity);
	}
}
