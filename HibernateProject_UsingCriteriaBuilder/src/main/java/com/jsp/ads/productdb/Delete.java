package com.jsp.ads.productdb;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		
		CriteriaBuilder sb = session.getCriteriaBuilder();
		CriteriaDelete<Product> cd = sb.createCriteriaDelete(Product.class);
		Root<Product> root = cd.from(Product.class);
		cd.where(sb.equal(root.get("productId"), 101));
		
		session.createQuery(cd).executeUpdate();
		
		tran.commit();
		sf.close();
	}

}
