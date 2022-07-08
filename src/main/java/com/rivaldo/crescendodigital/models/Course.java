package com.rivaldo.crescendodigital.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseID;
	
	@Column(name="course_n", nullable=false)
	private String courseName;
	
	@Column(name="course_i", nullable=false)
	private String courseIntructor;
	
	//findCourseByCourseInstructor
	public Course(Integer courseID, String courseName, String courseIntructor) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseIntructor = courseIntructor;
	}
	
	public Course() {}

	public Integer getCourseID() {
		return courseID;
	}

	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseIntructor() {
		return courseIntructor;
	}

	public void setCourseIntructor(String courseIntructor) {
		this.courseIntructor = courseIntructor;
	}

	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + ", courseIntructor=" + courseIntructor
				+ "]";
	}
	
	
	
}
