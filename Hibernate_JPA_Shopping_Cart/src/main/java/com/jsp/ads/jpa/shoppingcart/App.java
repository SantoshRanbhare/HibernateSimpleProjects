package com.jsp.ads.jpa.shoppingcart;

import com.jsp.ads.jpa.shoppingcart.service.ShoppingCartService;

public class App 
{
	public static void main( String[] args )
	{

		System.out.println("\t\t*********Welcome To Shopping Cart Application**********\n1. Add Product\n2. Add User\n"
				+ "3. Adding Product into Cart\n4. Find All Products in Cart\n5. Remove Product From Cart\n\nEnter Your Choice");
		int choice = ShoppingCartService.scanner.nextInt();
		ShoppingCartService.scanner.nextLine();
		switch(choice) {
		case 1 : ShoppingCartService.addProduct();
		break;
		case 2 : ShoppingCartService.addUser();
		break;
		case 3 : ShoppingCartService.addingProductIntoCart();
		break;
		case 4 : ShoppingCartService.findAllProductsInCart();
		break;
		case 5 : ShoppingCartService.removeProductFromCart();
		break;
		default : System.err.println("Invalid Choice");
		}
	}
}
