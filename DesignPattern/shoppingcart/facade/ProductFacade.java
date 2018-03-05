package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryDao;
import com.metacube.shoppingcart.dao.ProductFactory;
import com.metacube.shoppingcart.dao.db;
import com.metacube.shoppingcart.dao.status;
import com.metacube.shoppingcart.entity.Product;



public class ProductFacade {
	private static ProductFacade obj;
	
	InMemoryDao inmemorydao =(InMemoryDao) ProductFactory.getInstance(db.InMemory);
	
	public static ProductFacade getInstance() {
		if (obj == null) {
			obj = new ProductFacade();
		}
		
		return obj;
	}
	
	private ProductFacade() {}
	
	
	public List<Product> getAll(){
		return inmemorydao.getAll();
	}

	public status addProduct(Product product) {
		return inmemorydao.addProduct(product);	
	}
}
