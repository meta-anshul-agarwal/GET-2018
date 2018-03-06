package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.metacube.shoppingcart.entity.ShoppingCartProduct;

public class ProductFactory{
	
	private static BaseDao obj;
	public static BaseDao getInstance(db dbName) {
		switch(dbName){
		case InMemory : obj = new InMemoryDao();
						return obj;
		case Sql : return null;
		}
	return null;	
	}
	private ProductFactory() {}
	
}
