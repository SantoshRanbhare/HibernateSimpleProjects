package com.jsp.ads.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Customer customer1 = new Customer();
    	customer1.setCustomerId(101);
    	customer1.setCustomerName("Deva");
    	
    	Customer customer2 = new Customer();
    	customer2.setCustomerId(102);
    	customer2.setCustomerName("Abi"); 
    	
    	Product product1 = new Product();
    	product1.setProductId(1);
    	product1.setProductName("Theachers");
    	product1.setProductPrice(3500);
    	
    	Product product2 = new Product();
    	product2.setProductId(2);
    	product2.setProductName("Chips");
    	product2.setProductPrice(50);
    	
    	// Adding Products to Customer
    	customer1.getProducts().add(product1);
    	customer1.getProducts().add(product2);
    	customer2.getProducts().add(product1);
    	customer2.getProducts().add(product2);
    	
    	// Adding Customers to Product
    	product1.getCustomers().add(customer1);
    	product1.getCustomers().add(customer2);
    	product2.getCustomers().add(customer1);
    	product2.getCustomers().add(customer2);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Customer.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(customer1);
    	session.save(customer2);
    	session.save(product1);
    	session.save(product2);
    	
    	tran.commit();
    	sf.close();
    }
}
