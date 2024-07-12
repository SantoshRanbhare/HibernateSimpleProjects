package com.jsp.ads.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Product product1 = new Product();
    	product1.setProductName("Laptop");
    	product1.setProductPrice(78999);
    	
    	Product product2 = new Product();
    	product2.setProductName("Pen");
    	product2.setProductPrice(20);
    	
    	Customer customer1 = new Customer();
    	customer1.setCustomerName("Sandy");
    	customer1.setCutomerMbNo(7996105150L);

    	Customer customer2 = new Customer();
    	customer2.setCustomerName("Harsha");
    	customer2.setCutomerMbNo(805044004L);
    	
    	// Adding Product Objects into Customer Objects
    	customer1.getProducts().add(product1);
    	customer1.getProducts().add(product2);
    	customer2.getProducts().add(product1);
    	customer2.getProducts().add(product2);
    	
    	// Adding Cutomer Objects into Product Objects
//    	product1.getCustomers().add(customer1);
//    	product1.getCustomers().add(customer2);
//    	product2.getCustomers().add(customer1);
//    	product2.getCustomers().add(customer2);
    	
    	SessionFactory sf = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Customer.class).buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(customer1);
    	session.save(customer2);
    	session.save(product1);
    	session.save(product2);
    	
    	
    	tran.commit();
    	sf.close();
    	session.close();
    }
}
