package com.jsp.ads.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Company company = new Company();
    	company.setCompanyName("MicroSoft");
    	
    	Employee employee1 = new Employee();
    	employee1.setEmployeeName("Deva");
    	employee1.setDesignation("Java Developer");
    	employee1.setEmployeeSalary(50000);

    	Employee employee2 = new Employee();
    	employee2.setEmployeeName("Abi");
    	employee2.setDesignation("FullStack developer");
    	employee2.setEmployeeSalary(65000);
    	
    	// Adding Employee Objects in Company
//    	company.getEmployees().add(employee1);
//    	company.getEmployees().add(employee2);
    	
    	// Adding Company Object into Employees
    	employee1.setCompany(company);
    	employee2.setCompany(company);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Company.class).addAnnotatedClass(Employee.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session =sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(company);
    	session.save(employee1);
    	session.save(employee2);
    	
    	tran.commit();
    	sf.close();
    	session.close();
    }
}
