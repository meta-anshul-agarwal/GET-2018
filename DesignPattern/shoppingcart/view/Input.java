package com.metacube.shoppingcart.view;

import java.util.List;
import java.util.Scanner;

import com.metacube.shoppingcart.controller.ProductController;
import com.metacube.shoppingcart.controller.ShoppingCartController;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCartProduct;
import com.metacube.shoppingcart.enums.Status;

// Taking Input and showing Output
public class Input {
	static Scanner input  = new Scanner(System.in);
	public void takeInput(){
		int choice;
		
		// controller object
		ShoppingCartController shoppingCartControl = ShoppingCartController.getInstance();
		
		ProductController productController = ProductController.getInstance(); 
		
		// product List initialization
		productController.productInitialization();
		
		int quantity ;
		int productId;
		Status st;
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
					for(Product s: productController.getAllProducts()){
						System.out.println(s.getId() + "  " + s.getName()+"  "+s.getPrice() +" "+s.getStock());
					}
					break;
				case 2: 
					System.out.println("Enter product id");
					productId = input.nextInt();
					System.out.println("Enter quantity");
					quantity = input.nextInt();
					ShoppingCartProduct product = new ShoppingCartProduct(productId , quantity);
					st = shoppingCartControl.addShoppingProduct(product);
					System.out.println(st);
					break;
				case 3: 
					System.out.println("Enter product id");
					productId = input.nextInt();
					st = shoppingCartControl.deleteShoppingProduct(productId);
					System.out.println(st);
					break;
				case 4:
					System.out.println("Enter product id");
					productId = input.nextInt();
					System.out.println("Enter updated quantity");
					quantity = input.nextInt();
					st = shoppingCartControl.updateShoppingProduct(productId , quantity);
					break;
				case 5: 
					for(ShoppingCartProduct s: shoppingCartControl.getAllShoppingCartProducts()){
						for(Product p: productController.getAllProducts()){
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
