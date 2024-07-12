package com.jsp.ads.movie;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UsingCBWhereMethod {
	
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Movie.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> root = cq.from(Movie.class);
		
//		cq.where(cb.equal(root.get("movieId"), 102));
		
//		cq.where(cb.between(root.get("movieId"), 101, 103));
		
		cq.where(cb.lt(root.get("movieId"),102));
		cq.where(cb.equal(root.get("movieName"), "KGF"));
		
		cq.select(root); // If we skip this select clause also it will fetch all the records 
						 // But its mandatory when you are fetching Specific Thing.
		
		Query<Movie> query = session.createQuery(cq);
		List<Movie> movies = query.list(); // Here The Query is executed At Run Time
		for(Movie movie : movies) {
			System.out.println(movie);
		}
		
		tran.commit();
		sf.close();
	}

}
