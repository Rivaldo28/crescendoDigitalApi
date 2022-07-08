package com.rivaldo.crescendodigital.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivaldo.crescendodigital.models.Course;
import com.rivaldo.crescendodigital.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> allCourses() {
		List<Course> ac = courseRepository.findAll();
		return ac;
	}
	
	public Optional<Course> singleCourse(Integer courseID) throws Exception{
		Optional<Course> singleCourse = courseRepository.findById(courseID);
		
		if(!singleCourse.isPresent()){
			throw new Exception("Curso não existe");
		}
		return singleCourse;
	}
	
	
	public String updateCourse(Integer courseID, Course updatedCourseData) {
		courseRepository.updateCourseById(
				updatedCourseData.getCourseName(), 
				updatedCourseData.getCourseIntructor(), 
				courseID
				);
		return "Atualizando o curso!";
		
	}
	
	public String deletCourse(Integer courseID){
		courseRepository.deleteById(courseID);
		return "Deletado com sucesso!";
	}
	
	public String postCourse(Course course){
		courseRepository.save(course);
		return "Salvo com sucesso!";
	}
	
	public List<Course> findByCourseIntructor(String name){
		return courseRepository.findByCourseIntructor(name);
	}
	
	public List<Course> findByCourseNameContaining(String name){
		return courseRepository.findByCourseNameContaining(name);
	}
}
