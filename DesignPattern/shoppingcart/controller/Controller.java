package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.dao.status;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.facade.ProductFacade;

public class Controller {
	ProductFacade productFacade = ProductFacade.getInstance();
	private static Controller obj;
	
	public static Controller getInstance() {
		if (obj == null) {
			obj = new Controller();
		}
		
		return obj;
	}
	
	public status addProduct(Product product){
		return productFacade.addProduct(product);
	}
	
	public List<Product> getAll(){
		return productFacade.getAll();
	}
}
