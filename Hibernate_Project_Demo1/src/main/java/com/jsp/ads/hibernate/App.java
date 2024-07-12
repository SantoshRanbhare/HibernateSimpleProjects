package com.jsp.ads.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
//    	Student student = new Student();
//    	student.setStudentId(101);
//    	student.setStudentName("Deva");
//    	student.setStudentEmail("deva@gmail.com");
//    	student.setStudentMarks(97);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);;
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
//    	session.save(student);
    		
    	// get()
//		Student student1 = session.get(Student.class, 101);
//		System.out.println(student1);
//		
    	// load()
//		Student student2 = session.load(Student.class, 101);
//		System.out.println(student2);
    	
    	
    	// Update
//    	Student student1 = session.get(Student.class, 101);
//    	student1.setStudentId(101);
//    	student1.setStudentName("Abi");
//    	student1.setStudentEmail("abi@gmail.com");
//    	student1.setStudentMarks(25);
//    	session.update(student1);4
    	
    	// Delete
    	Student student1 = session.get(Student.class, 101);
    	session.delete(student1);
    	
		tran.commit();
		session.close(); 
		sf.close();
    }
}
