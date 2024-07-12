package com.jsp.ads.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Person person = new Person();
    	person.setPersonName("Deva");
    	person.setPersonMarks(98);
    	
    	Pan pan = new Pan();
    	pan.setPanNum("FSEPR5329N");
    	
    	// Adding Pan Object into Person Object
    	person.setPan(pan);
    	
    	// Adding Person Object into Pan Object
    	pan.setPerson(person);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Pan.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(person);
    	session.save(pan);
    	
    	tran.commit();
    	sf.close();
    	session.close();
    }
}
