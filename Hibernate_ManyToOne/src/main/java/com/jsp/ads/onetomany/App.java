package com.jsp.ads.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Employee employee1 = new Employee();
    	employee1.setEmployeeName("Santhosh");
    	employee1.setDegisnation("Java Developer");
    	employee1.setEmployeeSalary(50000);

    	Employee employee2 = new Employee();
    	employee2.setEmployeeName("Yogesh");
    	employee2.setDegisnation("Web Developer");
    	employee2.setEmployeeSalary(45000);
    	
    	Company company = new Company();
    	company.setCompanyName("Delliote");
    	
    	// Adding Employee Objects into Company
    	employee1.setCompany(company);
    	employee2.setCompany(company);
    	
    	// Adding Company Object into Employee
//    	company.getEmployees().add(employee1);
//    	company.getEmployees().add(employee2);
    	
    	SessionFactory sf = new Configuration().configure().addAnnotatedClass(Company.class).addAnnotatedClass(Employee.class).buildSessionFactory();
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
