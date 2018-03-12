package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.enums.DBName;
import com.metacube.shoppingcart.facade.ShoppingCartProductFacade;

public class InMemoryProductDao {
	// product list
	static List<Product> productList = new ArrayList<Product>();
	private static InMemoryProductDao inMemoryProductDao;
	
	// database class object
	BaseDao basedao =(InMemoryShoppingCartDao) ProductFactory.getInstance(DBName.INMEMORY);
	
	// singleton object
	public static InMemoryProductDao getInstance() {
		if (inMemoryProductDao == null) {
			inMemoryProductDao = new InMemoryProductDao();
		}
		return inMemoryProductDao;
	}
	
	// initialize product list
	public InMemoryProductDao(){
		Product p1 = new Product(1,"Milk",38.0f,100);
		Product p2 = new Product(2,"Bread",20.0f,100);
		Product p3 = new Product(3,"Biscuit",30.0f,100);
		Product p4 = new Product(4,"Mad angles",10.0f,100);
		
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);
	}
	
	// returns product list
	public List<Product> getProductList() {
		return productList;
	}
	
}