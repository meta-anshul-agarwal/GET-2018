package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.facade.ProductFacade;

public class ProductController {
	ProductFacade productFacade = ProductFacade.getInstance();
	
	private static ProductController productController;
	
	// singleton object
	public static ProductController getInstance() {
		if (productController == null) {
			productController = new ProductController();
		}
		
		return productController;
	}
	
	// initialize product list
	public Status productInitialization(){
		return productFacade.productInitialization();
	}

	// calls facade for fetching product list
	public List<Product> getAllProducts() {
		return productFacade.getAllProducts();
	}
}
