package com.rivaldo.crescendodigital.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rivaldo.crescendodigital.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	List<Course> findByCourseIntructor(String couseIntructor);
	
	List<Course> findByCourseNameContaining(String cname);
	
	@Transactional
	@Modifying
	@Query("update Course c set c.courseName = ?1, c.courseIntructor = ?2 where c.courseID = ?3")
	void updateCourseById(String courseName, String courseInst, Integer courseID);
	
}
