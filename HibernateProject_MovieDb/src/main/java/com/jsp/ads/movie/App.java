package com.jsp.ads.movie;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.model.source.internal.hbm.AbstractEntitySourceImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Movie.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	
    	// By Using Place Holders 
    	
//    	Query<Movie> query = session.createQuery("UPDATE Movie m SET m.boxOfficeCollection = ?1 WHERE m.movieId = ?2");
//    	query.setParameter(1, 8000000.00);
//    	query.setParameter(2, 101);
    	
    	// By Using Keys 
    	
//    	Query<Movie> query = session.createQuery("UPDATE Movie m SET m.boxOfficeCollection = :boc WHERE m.movieId = :movieId");
//    	query.setParameter("boc", 25000000.00);
//    	query.setParameter("movieId", 101);
//    	
//    	int rowsUpdated = query.executeUpdate();
//    	if(rowsUpdated>0) {
//    		System.out.println(rowsUpdated+" Data Updated SuccessFully");
//    	}else {
//    		System.out.println("Data Not Updated");
//    	}
    	
    	
//    	Criteria criteria = session.createCriteria(Movie.class); // Creating Criteria Object And Knowing On Which Class we Are Dealing With
//    	List<Movie> movies = criteria.list();
//    	for(Movie movie : movies) {
//    		System.out.println(movie);
//    	}
    	
    	
    	// Fetch The Records Greater Than 101 using gt()
    	
//    	Criteria criteria = session.createCriteria(Movie.class); // Creating Criteria Object And Knowing that, On Which Class we Are Dealing With
//    	criteria.add(Restrictions.gt("movieId", 101)); // Building The Query Here
//    	List<Movie> movies = criteria.list(); // Query Gets Executed Here
//    	for(Movie movie : movies) {
//    		System.out.println(movie);
//    	}
    	
    	
    	// Fetch The Records Less Than 102 using lt()
    	
//    	Criteria criteria = session.createCriteria(Movie.class);
//    	criteria.add(Restrictions.lt("movieId", 102));
//    	List<Movie> movies = criteria.list();
//    	for(Movie movie : movies) {
//    		System.out.println(movie);
//    	}
    	
    	
    	// Fetch The Records Between 101 And 103 using between()
    	
//    	Criteria criteria = session.createCriteria(Movie.class);
//    	criteria.add(Restrictions.between("movieId", 101,103));
//    	List<Movie> movies = criteria.list();
//    	for(Movie movie : movies) {
//    		System.out.println(movie);
//    	}
    	

    	// Fetch The Records Like movieId Like 101 using like()
    	
//    	Criteria criteria = session.createCriteria(Movie.class);
//    	criteria.add(Restrictions.like("movieId", 101));
//    	Movie movies = (Movie)criteria.uniqueResult();
//    	System.out.println(movies);
    	
    	// Fetch The Records Whose movieId is equals to 102 using eq() 
    	
    	Criteria criteria = session.createCriteria(Movie.class);
    	criteria.add(Restrictions.eq("movieId", 102));
    	Movie movies = (Movie)criteria.uniqueResult(); // uniqueResult() used to fetch only one record
    	System.out.println(movies);
    	
    	tran.commit();
    	sf.close();
    }
}
