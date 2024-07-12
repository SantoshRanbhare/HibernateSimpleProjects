package com.jsp.ads.persondb.HibernsteProject_ByDirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Person person = new Person();
    	person.setPersonId(101);
    	person.setPersonName("Sandy");
    	
    	Pan pan = new Pan();
    	pan.setPanId(1);
    	pan.setPanNum("FSEPR5329N");
    	
//    	// Adding Pan into Person
//    	person.setPan(pan);
    	
    	// Adding Person into Pan
    	pan.setPerson(person);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Pan.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	
    	
//    	session.save(person);
//    	session.save(pan);
    	
    	Person pers = session.get(Person.class, 101);
    	System.out.println(pers);
//    	Pan pa = pers.getPan();
//    	System.out.println(pa);
    	
    	tran.commit();
    	sf.close();
    	session.close();
    	
    }
}
