package com.jsp.ads.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Company company = new Company();
    	company.setCompanyId(1);
    	company.setCompanyName("Microsoft");
    	
    	Employee employee1 = new Employee();
    	employee1.setEmployeeId(101);
    	employee1.setEmployeeName("Santhosh");
    	employee1.setEmployeeSalary(2500000.0);
    	
    	Employee employee2 = new Employee();
    	employee2.setEmployeeId(102);
    	employee2.setEmployeeName("Deva");
    	employee2.setEmployeeSalary(5000000.0);
    	
    	Employee employee3 = new Employee();
    	employee3.setEmployeeId(103);
    	employee3.setEmployeeName("Deva");
    	employee3.setEmployeeSalary(1000000.0);
    	
    	//
    	employee1.setCompany(company);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Company.class).addAnnotatedClass(Employee.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	
    	tran.commit();
    	sf.close();
    }
}
