package com.jsp.ads.jpa.shoppingcart.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.jsp.ads.jpa.shoppingcart.entity.Cart;
import com.jsp.ads.jpa.shoppingcart.entity.Product;
import com.jsp.ads.jpa.shoppingcart.entity.User;

public class ShoppingCartService {

	public static Scanner scanner = new Scanner(System.in);

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("shoppingCart");
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction et = em.getTransaction();

	public static void addProduct() {
		et.begin();

		Product product = new Product();
		System.out.println("Enter the Product Name");
		product.setProductName(scanner.nextLine());
		System.out.println("Enter the Product Brand");
		product.setProductBrand(scanner.nextLine());
		System.out.println("Enter the Product Price");
		product.setProductPrice(scanner.nextInt());

		em.persist(product);

		et.commit();
		emf.close();
		em.close();
		scanner.close();
	}

	public static void addUser() {

		et.begin();

		User user = new User();
		System.out.println("Enter User Name");
		user.setUserName(scanner.nextLine());
		System.out.println("Enter User Email");
		user.setUserEmail(scanner.nextLine());
		System.out.println("Enter Password");
		user.setUserPassword(scanner.nextLine()); 

		Cart cart = new Cart();
//		System.out.println("Enter Cart Id");
//		cart.setCartId(scanner.nextInt());
		System.out.println(cart.getCartId());
		
		// Adding Cart object into User Object
		user.setCart(cart);

		em.persist(user);
		em.persist(cart);

		et.commit();
		emf.close();
		em.close();
		scanner.close();
	}

	public static void addingProductIntoCart() {

		List<User> users = validateUser();

		et.begin();
		// Here I got The Cart
		User user = users.get(0);
		Cart cart = user.getCart();

		// To Diplay All The Products Details So That User Can Select Easily
		findAllProductsInCart();

		System.out.println("Enter How Many Products You Want to Buy\n");
		int noOfProducts = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Add Product Names");
		List<String> pNames = new LinkedList<String>();
		for(int i=0;i<noOfProducts;i++) {
			pNames.add(scanner.nextLine());
		}


		for(String pName : pNames) {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Product> cq1 = cb.createQuery(Product.class);
			Root<Product> root1 = cq1.from(Product.class);
			cq1.where(cb.equal(root1.get("productName"), pName));
			List<Product> products = em.createQuery(cq1).getResultList();
			if(products.isEmpty()) {
				System.err.println("Product Not Found");
				return;
			}
			else {
				for(Product product : products) {
					cart.getProducts().add(product);
				}
			}
		}

		// Take the Products From Cart Object And Save it Using persist method
		for(Product product : cart.getProducts()) {
			em.persist(product);
		}


		et.commit();
		emf.close();
		em.close();
		scanner.close();
	}

	private static List<User> validateUser() {
		System.out.println("Enter User Email");
		String userMail = scanner.nextLine().trim();
		System.out.println("Enter Password");
		String userPassword = scanner.nextLine().trim();

		// Validation Using CriteriaBuilder
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.where(
				cb.and(
						cb.equal(root.get("userEmail"), userMail),
						cb.equal(root.get("userPassword"), userPassword)
						)
				);
		List<User> users = em.createQuery(cq).getResultList();
		if(users.isEmpty()) {
			System.err.println("\n\nInvalid UserName or Password\n\n");
			return null;
		}
		return users;
	}

	public static void removeProductFromCart() {

		et.begin();

		// Calling validateUser() method to Validate User
		List<User> users = validateUser();
		//		if(users == null) {
		//			return;
		//		}
		User user = users.get(0);
		Cart cart = user.getCart();
		List<Product> products = cart.getProducts();
		for(Product product : products) {
			System.out.println(product);
		}
		

		System.out.println("\nEnter Product Id to Delete");
		int productId = scanner.nextInt();
		Iterator<Product> iterator = products.iterator();
		while(iterator.hasNext()) {
			Product product = iterator.next();
			if(product.getProductId() == productId) {
				iterator.remove();
				System.err.println("\nProduct Removed With Id: "+ productId);
				break;
			}
		}
		System.err.println("\nProduct With Id "+productId +" is Not Found");
		et.commit();
		emf.close();
		em.close();
		scanner.close();
	}

	public static void findAllProductsInCart() {

		et.begin();

		List<User> users = validateUser();
		User user = users.get(0);
		Cart cart = user.getCart();
		
		List<Product> products = cart.getProducts();
		
		for(Product product : products) {
			System.out.println(product);
		}
		et.commit();
		emf.close();
		em.close();
	}
}

