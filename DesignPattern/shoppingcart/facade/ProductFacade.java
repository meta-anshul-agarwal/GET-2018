package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryShoppingCartDao;
import com.metacube.shoppingcart.dao.InMemoryProductDao;
import com.metacube.shoppingcart.dao.ProductFactory;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.enums.DBName;
import com.metacube.shoppingcart.enums.Status;


public class ProductFacade {
	
	InMemoryProductDao productdao =InMemoryProductDao.getInstance();
	
	private static ProductFacade productFacade;
	
	// singleton object
	public static ProductFacade getInstance() {
		if (productFacade == null) {
			productFacade = new ProductFacade();
		}
		return productFacade;
	}
	
	// returns list of all products in database
	public List<Product> getAllProducts() {
		return productdao.getProductList();
	}

	public static Status productInitialization() {
		InMemoryProductDao productdao = InMemoryProductDao.getInstance();
		return Status.CREATED;
	}

}
