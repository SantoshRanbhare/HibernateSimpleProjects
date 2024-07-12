package com.jsp.ads.productdb;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update 
{
    public static void main( String[] args )
    {
    	
    	SessionFactory sf = new Configuration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	CriteriaBuilder cb = session.getCriteriaBuilder();
    	CriteriaUpdate<Product> cu = cb.createCriteriaUpdate(Product.class);
    	Root<Product> root = cu.from(Product.class);
    	
    	cu.set("productPrice", 99000);
    	cu.where(cb.equal(root.get("productId"), 102));
    	
    	session.createQuery(cu).executeUpdate();
    	
    	tran.commit();
    	sf.close();
    }
}
