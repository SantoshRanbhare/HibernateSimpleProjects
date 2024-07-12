package com.jsp.ads.hibernate.coursedb;

import com.jsp.ads.hibernate.coursedb.service.CourseService;

public class App 
{
	public static void main( String[] args )
	{
		System.out.println("\n\t\t*************Welcome To Course Database**********\n"
				+ "1. Add Course\n2. Find Course By Id\n3. Find Course By Name\n4. Find All Courses\n"
				+ "5. Find All Courses Between Prices\n6. Update Course Price By Id\n7. Update Time Duration By Course Name\n"
				+ "8. Update Number Of Faculties By Course Id\n9. Delete Course By Id\n10. Delete Course Between Course Fees\n"
				+ "11. Delete All Courses\n\nEnter Your Choice");
		int choice = CourseService.scanner.nextInt();

		switch(choice) {
		case 1 : CourseService.addCourse();
		break;
		case 2 : CourseService.findCourseById();
		break;
		case 3 : CourseService.findCourseByName();
		break;
		case 4 : CourseService.findAllCourses();
		break;
		case 5 : CourseService.findAllCoursesBetweenPrices();
		break;
		case 6 : CourseService.updateCoursePriceById();
		break;
		case 7 : CourseService.updateTimeDurationByCourseName();
		break;
		case 8 : CourseService.updateNoOfFacultiesByCourseId();
		break;
		case 9 : CourseService.deleteCourseById();
		break;
		case 10 : CourseService.deleteCourseBetweenCourseFees();
		break;
		case 11 : CourseService.deleteAllCourses();
		break;
		default : System.out.println("Invalid Choice");
		}
	}
}
