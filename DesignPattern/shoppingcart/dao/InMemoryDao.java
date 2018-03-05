package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.metacube.shoppingcart.entity.Product;

public class InMemoryDao implements BaseDao {
	
	Map<String , Product> productMap = new HashMap<>();

	public List<Product> getAll() {
		List<Product> list = new ArrayList<Product>(productMap.values());
		return list;
	}

	public status addProduct(Product product) {
		this.productMap.put(product.getId(), product);
		return status.Created;
		
	}
	
}
