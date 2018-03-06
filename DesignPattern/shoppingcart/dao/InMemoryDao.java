package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCartProduct;

public class InMemoryDao implements BaseDao {
	
	Map<Integer , ShoppingCartProduct> productMap = new HashMap<>();
	

	public List<ShoppingCartProduct> getAllShoppingCartProducts() {
		List<ShoppingCartProduct> shoppingProductList = new ArrayList<ShoppingCartProduct>(productMap.values());
		return shoppingProductList;
	}

	public status addProduct(ShoppingCartProduct product) {
		
		this.productMap.put(product.getId(), product);
		ProductDao productdao = ProductDao.getInstance();
		for(Product p : productdao.getProductList()){
			if(p.getId() == product.getId()){
				p.setStock(product.getQuantity());
				productdao.productList.set(p.getId()-1, p);
				
			}
		}
		
		return status.Created;
		
	}

	@Override
	public status deleteShoppingProduct(int id) {
		// TODO Auto-generated method stub
		productMap.remove(id);
		return status.Deleted;
	}

	@Override
	public status updateShoppingProduct(int productId, int quantity) {
		// TODO Auto-generated method stub
		ProductDao productdao = ProductDao.getInstance();
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
