package com.jsp.ads.hibernate.coursedb.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.jsp.ads.hibernate.coursedb.entity.Course;

public class CourseService {
	public static Scanner scanner = new Scanner(System.in);

	private static SessionFactory getSessionFactory() {
		return new Configuration().configure().addAnnotatedClass(Course.class).buildSessionFactory();
	}

	public static void addCourse() {

		// Creating Session Object using openSession() Method
		Session session = getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();

		// Setting All Data By Using Setter Mathod
		Course course = new Course();
		System.out.println("Enter Course Id:");
		course.setCourseId(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Enter Course Name");
		course.setCourseName(scanner.nextLine());
		System.out.println("Enter Course Fees");
		course.setCourseFees(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Enter Course Time Duration");
		course.setTimeDuration(scanner.nextLine());
		System.out.println("Enter Number Of Faculty");
		course.setNoOfFaculty(scanner.nextInt());

		// Saving By Using inbuilt method save()
		session.save(course);

		tran.commit();
		getSessionFactory().close();
		session.close();
	}

	public static void findCourseById() {
		
		// Creating Session Object using openSession() Method
		Session session = getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();

		// HQL Query By using Query interface
		Query<Object> query = session.createQuery("from Course c where c.courseId = :cid"); // ?1
		System.out.println("Enter Id to Fetch");
		query.setParameter("cid", scanner.nextInt()); // query.setParameter(1, scanner.nextInt());
		Course rs = (Course)query.uniqueResult();
		System.out.println(rs);
		
		tran.commit();
		getSessionFactory().close();
		session.close();
	}
	
	public static void findCourseByName() {
		
		// Creating the Session Object by invoking the openSession() method
		Session session = getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		
		// fetching Course By invoking createNativeQuery() method
		NativeQuery<Course> query = session.createNativeQuery("select * from Course where courseName = :cname",Course.class);
		System.out.println("Enter Course Name:");
		query.setParameter("cname", scanner.nextLine());
		List<Course> courses = query.list();
		for(Course course : courses) {
			System.out.println(course);
		}
		
		tran.commit();
		getSessionFactory().close();
		session.close();
	}
	
	public static void findAllCourses() {
		
		// Creating the Object of Session by using openSession() method
		Session session = getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		
		// Fetching All The Data By using Criteria interface
		Criteria criteria = session.createCriteria(Course.class);
		List<Course> courses = criteria.list();
		for(Course course : courses) {
			System.out.println(course);
		}
		
		tran.commit();
		getSessionFactory().close();
		session.close();
	}
	
	
	public static void findAllCoursesBetweenPrices() {
		
		// Creating the Object of Session by invoking openSession() method
		Session session = getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		
		// Fetch Data By Using 
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> root = cq.from(Course.class);
		System.out.println("Enter The Fees Between You Want to Fetch The Data");
		cq.where(cb.between(root.get("courseFees"), scanner.nextInt(), scanner.nextInt()));
		
		Query<Course> query = session.createQuery(cq);
		List<Course> courses = query.list();
		for(Course course : courses) {
			System.out.println(course);
		}
		
		tran.commit();
		getSessionFactory().close();
		session.clear();
	}
	
	public static void updateCoursePriceById() {
		
		// Create the Object of Session by invoking openSession() method
		Session session = getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		
		// Invoke get() to fetch the data
		System.out.println("Enter Id to Update the Details Of Course");
		Course course = session.get(Course.class, scanner.nextInt());
		System.out.println(course);
		System.out.println("Enter Price To Update");
		course.setCourseFees(scanner.nextInt());
		session.update(course);
		
		tran.commit();
		System.out.println(course);
		getSessionFactory().close();
		session.close();
	}
	
	public static void updateTimeDurationByCourseName() {
		
		// Create The Object Session and invoke openSession() method
		Session session = getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		
		// By Using Query interface
		Query query = session.createQuery("Update Course c set c.timeDuration = :tDuration where c.courseName= :cname");
		System.out.println("Enter Course Name To Update time Duration Of Course");
		query.setParameter("cname", scanner.nextLine());
		System.out.println("Enter The Time Duration What you Want to Update");
		query.setParameter("tDuration", scanner.nextLine());
		
		query.executeUpdate();
		
		tran.commit();
		getSessionFactory().close();
		session.close();
	}
	
	public static void updateNoOfFacultiesByCourseId() {
		
		// Create Object of Session By Using openSession() method
		Session session = getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaUpdate<Course> cu = cb.createCriteriaUpdate(Course.class);
		Root<Course> root = cu.from(Course.class);
		System.out.println("Enter Course Id Update Number Of Faculty");
		cu.where(cb.equal(root.get("courseId"), scanner.nextInt()));
		System.out.println("Enter Enter NUmber Of Faculty To Update");
		cu.set(root.get("noOfFaculty"), scanner.nextInt());
		
		session.createQuery(cu).executeUpdate();
		
		tran.commit();
		getSessionFactory().close();
		session.close();
	}
	
	public static void deleteCourseById() {
		
		// Create Object of Session By using openSession() method
		Session session = getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		
		// Using inbuilt method delete()
 		System.out.println("Enter Course Id To Delete");
		Course course = session.get(Course.class, scanner.nextInt());
		session.delete(course);
		
		tran.commit();
		getSessionFactory().close();
		session.close();
	}
	
	public static void deleteCourseBetweenCourseFees() {
		
		// Create Object of Session By Invoking openSession() method
		Session session = getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		
		// By using CriteriaBuilder interface
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaDelete<Course> cd = cb.createCriteriaDelete(Course.class);
		Root<Course> root = cd.from(Course.class);
		System.out.println("Enter Stating Fees and Ending Fees to delete");
		cd.where(cb.between(root.get("courseFees"), scanner.nextInt(), scanner.nextInt()));
		
		session.createQuery(cd).executeUpdate();
		
		tran.commit();
		getSessionFactory().close();
		session.close();
		
	}
	
	public static void deleteAllCourses() {
		
		// Create Object of Session by invoking openSession() method
		Session session = getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		
		NativeQuery<Course> query = session.createNativeQuery("Delete from Course", Course.class);
		query.executeUpdate();
		
		tran.commit();
		getSessionFactory().close();
		session.close();
	}
}

