package com.jsp.ads.persondb;

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
    	company.setCompanyName("MicroSoft");
    	
    	Employee employee1 = new Employee();
    	employee1.setEmployeeId(101);
    	employee1.setEmployeeName("Sandy");
    	employee1.setEmployeeSalary(5800000);
    	
    	Employee employee2 = new Employee();
    	employee2.setEmployeeId(102);
    	employee2.setEmployeeName("Deva");
    	employee2.setEmployeeSalary(4500000);
    	
    	company.getEmployees().add(employee1);
    	company.getEmployees().add(employee2);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Company.class).addAnnotatedClass(Employee.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(company);
    	session.save(employee1);
    	session.save(employee2);
    	
    	tran.commit();
    	sf.close();
    	session.close();
    }
}
