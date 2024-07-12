package com.jsp.ads.hibernate.coursedb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	private int courseId;
	private String courseName;
	private int courseFees;
	private String timeDuration;
	private int noOfFaculty;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(int courseFees) {
		this.courseFees = courseFees;
	}
	public String getTimeDuration() {
		return timeDuration;
	}
	public void setTimeDuration(String timeDuration) {
		this.timeDuration = timeDuration;
	}
	public int getNoOfFaculty() {
		return noOfFaculty;
	}
	public void setNoOfFaculty(int noOfFaculty) {
		this.noOfFaculty = noOfFaculty;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseFees=" + courseFees
				+ ", timeDuration=" + timeDuration + ", noOfFaculty=" + noOfFaculty + "]";
	}
	
}
