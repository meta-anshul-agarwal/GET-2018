package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryDao;
import com.metacube.shoppingcart.dao.ProductDao;
import com.metacube.shoppingcart.dao.ProductFactory;
import com.metacube.shoppingcart.dao.db;
import com.metacube.shoppingcart.entity.Product;


public class ProductFacade {
	
	ProductDao productdao = new ProductDao();
	private static ProductFacade obj;
	
	// singleton object
	public static ProductFacade getInstance() {
		if (obj == null) {
			obj = new ProductFacade();
		}
		
		return obj;
	}
	
	// returns list of all products in database
	public List<Product> getAllProducts() {
		return productdao.getProductList();
	}

}
