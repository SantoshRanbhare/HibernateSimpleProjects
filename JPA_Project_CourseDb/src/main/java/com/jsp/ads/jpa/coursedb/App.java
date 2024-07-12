package com.jsp.ads.jpa.coursedb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.ads.jpa.coursedb.entity.Course;

public class App 
{
    public static void main( String[] args )
    {
    	Course course = new Course();
    	course.setCourseId(101);
    	course.setCourseName("Java");
    	course.setCourseFees(35000);
    	course.setTimeDuration("3 months");
    	course.setNoOfFaculty(5);
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("coursedb");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();
    	
    	et.begin();
    	
    	em.persist(course);
    	
    	et.commit();
    	emf.close();
    	em.close();
    	
    }
}
