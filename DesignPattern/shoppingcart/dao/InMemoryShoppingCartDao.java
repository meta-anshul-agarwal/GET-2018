package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCartProduct;
import com.metacube.shoppingcart.enums.Status;

public class InMemoryShoppingCartDao implements BaseDao {
	
	// map to hold shopping products
	Map<Integer , ShoppingCartProduct> productMap = new HashMap<>();
	
	// returns all shopping products
	public List<ShoppingCartProduct> getAllShoppingCartProducts() {
		List<ShoppingCartProduct> shoppingProductList = new ArrayList<ShoppingCartProduct>(productMap.values());
		return shoppingProductList;
	}

	// add product in map and returns status
	public Status addShoppingProduct(ShoppingCartProduct product) {
		
		this.productMap.put(product.getId(), product);
		InMemoryProductDao productdao = InMemoryProductDao.getInstance();
		
		// loop for updating stock
		for(Product p : productdao.getProductList()){
			if(p.getId() == product.getId()){
				p.setStock(product.getQuantity());
				productdao.productList.set(p.getId()-1, p);
				
			}
		}
		
		return Status.CREATED;
		
	}

	// delete product from map and returns status
	@Override
	public Status deleteShoppingProduct(int id) {
		productMap.remove(id);
		return Status.DELETED;
	}

	// updates product quantity
	@Override
	public Status updateShoppingProduct(int productId, int quantity) {
		InMemoryProductDao productdao = InMemoryProductDao.getInstance();
		
		// loop to update stock in product list
		for(Product p : productdao.getProductList()){
			if(p.getId() == productId){
				p.setUpdatedStock(quantity);
				productdao.productList.set(p.getId()-1, p);	
			}
		}
		
		ShoppingCartProduct shoppingCartProduct = productMap.get(productId);
		shoppingCartProduct.setQuantity(quantity);
		
		return Status.UPDATED;
	}
	
	
	
}
