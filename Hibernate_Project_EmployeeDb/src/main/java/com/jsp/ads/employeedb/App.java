package com.jsp.ads.employeedb;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	Employee_Service service = new Employee_Service();

    	Scanner scanner = new Scanner(System.in);
    	System.out.println("\t\t***********Employee Database**********\n1.Add Employee    2.Display Employee Details    3.Update Employee Details    4.Delete Employee    5.Display All Data\nEnter Your Choice");
    	int choice = scanner.nextInt();
    	
    	switch (choice) {
		case 1: service.addEmployeeData();
		break;
		case 2: service.fetchEmployeeDataById();
		break;
		case 3: service.updateEmployeeById();
		break;
		case 4: service.deleteEmployeeById();
		break;
		case 5: service.displayAllEmployeeData();
		break;
		default: System.err.println("Invalid Choice");
		}
    	scanner.close();
    }
}
