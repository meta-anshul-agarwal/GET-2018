package com.metacube.shoppingcart.view;

import java.util.List;
import java.util.Scanner;

import com.metacube.shoppingcart.controller.Controller;
import com.metacube.shoppingcart.dao.status;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCartProduct;

// Taking Input and showing Output
public class Input {
	static Scanner input  = new Scanner(System.in);
	public void takeInput(){
		int choice;
		
		// controller object
		Controller control = Controller.getInstance();
		
		// product List initialization
		control.productInitialization();
		int quantity ;
		int productId;
		status st;
		do{
			System.out.println("1. Show All Products");
			System.out.println("2. Add Product");
			System.out.println("3. Delete Product");
			System.out.println("4. Update Product");
			System.out.println("5. Show Cart Products");
			System.out.println("Enter ur choice");
			choice = input.nextInt();
			switch(choice) {
				case 1:
					for(Product s: control.getAllProducts()){
						System.out.println(s.getId() + "  " + s.getName()+"  "+s.getPrice() +" "+s.getStock());
					}
					break;
				case 2: 
					System.out.println("Enter product id");
					productId = input.nextInt();
					System.out.println("Enter quantity");
					quantity = input.nextInt();
					ShoppingCartProduct product = new ShoppingCartProduct(productId , quantity);
					st = control.addShoppingProduct(product);
					System.out.println(st);
					break;
				case 3: 
					System.out.println("Enter product id");
					productId = input.nextInt();
					st = control.deleteShoppingProduct(productId);
					System.out.println(st);
					break;
				case 4:
					System.out.println("Enter product id");
					productId = input.nextInt();
					System.out.println("Enter updated quantity");
					quantity = input.nextInt();
					st = control.updateShoppingProduct(productId , quantity);
					break;
				case 5: 
					for(ShoppingCartProduct s: control.getAllShoppingCartProducts()){
						for(Product p: control.getAllProducts()){
							if(s.getId() == p.getId())
								System.out.println( p.getId() + "  " + p.getName()+"  "+p.getPrice() + "  " + s.getQuantity());
						}
						
					}
					break;
				default:
					System.exit(0);
			}
		}while(true);
	}
}
