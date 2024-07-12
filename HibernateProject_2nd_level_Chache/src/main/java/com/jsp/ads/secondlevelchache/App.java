package com.jsp.ads.secondlevelchache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Dish dish = new Dish();
    	dish.setDishName("Chiken Biryani");
    	dish.setDishType("non-veg");
    	dish.setDishPrice(399.00);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Dish.class);
    	SessionFactory sf = cfg.buildSessionFactory();

    	// Session 1
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	Dish dish1 = session.get(Dish.class, 101);
    	System.out.println(dish1);
    	Dish dish2 = session.get(Dish.class, 101);
    	System.out.println(dish2);
    	tran.commit();
    	
    	System.out.println("----------------------------------------------------------------\n------------------------------------------------------------------------");
    	
    	// Session 2
    	Session session1 = sf.openSession();
    	Transaction tran2 = session1.beginTransaction();
    	
    	Dish dish3 = session1.get(Dish.class, 101);
    	System.out.println(dish3);
    	Dish dish4 = session1.get(Dish.class, 101);
    	System.out.println(dish4);
    	tran2.commit();

    	sf.close();
    }
}

