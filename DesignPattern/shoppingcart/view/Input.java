package com.metacube.shoppingcart.view;

import java.util.Scanner;

import com.metacube.shoppingcart.controller.Controller;
import com.metacube.shoppingcart.dao.status;
import com.metacube.shoppingcart.entity.Product;

public class Input {
	static Scanner input  = new Scanner(System.in);
	public void takeInput(){
		int choice;
		Controller control = Controller.getInstance();
		do{
			System.out.println("1. Add Product");
			System.out.println("2. Delete Product");
			System.out.println("3. Update Product");
			System.out.println("4. Show Products");
			System.out.println("Enter ur choice");
			choice = input.nextInt();
			switch(choice) {
				case 1: 
					System.out.println("Enter product name");
					String name = input.next();
					System.out.println("Enter price of : "+name);
					float price = input.nextFloat();
					Product product = new Product(name , price);
					status st = control.addProduct(product);
					System.out.println(st);
					break;
				case 2: 
					// delete product
				case 3:
					// update product
				case 4: 
					for(Product s: control.getAll()){
						System.out.println(s.getName()+"  "+s.getPrice() + " " + s.getId());
					}
					break;
				default:
					System.exit(0);
			}
		}while(true);
	}
}
