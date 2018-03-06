package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCartProduct;

public class InMemoryDao implements BaseDao {
	
	// map to hold shopping products
	Map<Integer , ShoppingCartProduct> productMap = new HashMap<>();
	
	// returns all shopping products
	public List<ShoppingCartProduct> getAllShoppingCartProducts() {
		List<ShoppingCartProduct> shoppingProductList = new ArrayList<ShoppingCartProduct>(productMap.values());
		return shoppingProductList;
	}

	// add product in map and returns status
	public status addShoppingProduct(ShoppingCartProduct product) {
		
		this.productMap.put(product.getId(), product);
		ProductDao productdao = ProductDao.getInstance();
		
		// loop for updating stock
		for(Product p : productdao.getProductList()){
			if(p.getId() == product.getId()){
				p.setStock(product.getQuantity());
				productdao.productList.set(p.getId()-1, p);
				
			}
		}
		
		return status.Created;
		
	}

	// delete product from map and returns status
	@Override
	public status deleteShoppingProduct(int id) {
		productMap.remove(id);
		return status.Deleted;
	}

	// updates product quantity
	@Override
	public status updateShoppingProduct(int productId, int quantity) {
		ProductDao productdao = ProductDao.getInstance();
		
		// loop to update stock in product list
		for(Product p : productdao.getProductList()){
			if(p.getId() == productId){
				p.setUpdatedStock(quantity);
				productdao.productList.set(p.getId()-1, p);	
			}
		}
		
		ShoppingCartProduct shoppingCartProduct = productMap.get(productId);
		shoppingCartProduct.setQuantity(quantity);
		
		return status.Updated;
	}
	
	
	
}
