package com.jsp.ads.employeedb;

import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Employee_Service {

	Scanner scanner = new Scanner(System.in);

	Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
	SessionFactory sf = cfg.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tran = session.beginTransaction();

	public void addEmployeeData() {

		Employee employee = new Employee();
		System.out.println("Enter Employee Id:");
		employee.setEmployeeId(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Enter Employee Name:");
		employee.setEmployeeName(scanner.nextLine());
		System.out.println("Enter Employee Email:");
		employee.setEmployeeMail(scanner.nextLine());
		System.out.println("Enter Employee Address");
		employee.setEmployeeAddress(scanner.nextLine());
		System.out.println("Enter Employee Salary");
		employee.setEmployeeSalary(scanner.nextDouble());

		session.save(employee);

		tran.commit();
		session.close();
		sf.close();
	}

	public void displayAllEmployeeData() {
		Iterator<Employee> it = session.createQuery("from Employee").list().iterator();
		System.out.println("\nEmployeeId\tEmployeeName\tEmployeeMail\t\tEmployeeAddress\t\tEmployeeSalary");
		while(it.hasNext())
		{
			Employee e = it.next();
			System.out.println(e.getEmployeeId()+"\t\t"+e.getEmployeeName()+"\t\t"+e.getEmployeeMail()+"\t\t"+e.getEmployeeAddress()+"\t\t"+
					e.getEmployeeSalary());
		}
	}

	public void updateEmployeeById() {
		System.out.println("Enter Employee Id to Update the Data");
		int employeeId = scanner.nextInt();
		Employee employee = session.get(Employee.class, employeeId);
		System.out.println(employee);
		employee.setEmployeeId(employeeId);
		scanner.nextLine();
		System.out.println("Enter Employee Name:");
		employee.setEmployeeName(scanner.nextLine());
		System.out.println("Enter Employee Email:");
		employee.setEmployeeMail(scanner.nextLine());
		System.out.println("Enter Employee Address");
		employee.setEmployeeAddress(scanner.nextLine());
		System.out.println("Enter Employee Salary");
		employee.setEmployeeSalary(scanner.nextDouble());

		session.update(employee);

		tran.commit();
		session.close();
		sf.close();
	}

	public void fetchEmployeeDataById() {
		System.out.println("Enter Employee Id To Fetch The Data");
		Employee employee = session.get(Employee.class, scanner.nextInt());
		System.out.println(employee);

		tran.commit();
		session.close();
		sf.close();
	}

	public void deleteEmployeeById() {
		System.out.println("Enter Employee Id To Delete The Data");
		Employee employee = session.get(Employee.class, scanner.nextInt());
		session.delete(employee);

		tran.commit();
		session.close();
		sf.close();
	}
}
