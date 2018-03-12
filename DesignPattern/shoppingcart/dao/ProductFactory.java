package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.metacube.shoppingcart.entity.ShoppingCartProduct;
import com.metacube.shoppingcart.enums.DBName;

// returns object of a particular database class object
public class ProductFactory{
	
	private static BaseDao basedao;
	public static BaseDao getInstance(DBName dbName) {
		
		switch(dbName){
		
			case INMEMORY : basedao = new InMemoryShoppingCartDao();
							return basedao;
							
			case SQL : return null;
		
		}
		return null;	
	
	}
	
	private ProductFactory() {}
	
}
