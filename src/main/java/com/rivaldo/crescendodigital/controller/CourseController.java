package com.rivaldo.crescendodigital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rivaldo.crescendodigital.models.Course;
import com.rivaldo.crescendodigital.services.CourseService;

@RestController
@RequestMapping(path="/api")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> allCourses() {
	return courseService.allCourses();
	}
	
	@GetMapping("/courses/{cid}")
	public Optional<Course> singleCourse(@PathVariable("cid") Integer courseID) throws Exception{
		try {			
			return courseService.singleCourse(courseID);
		}catch(Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage());
		}
	}
	
	@GetMapping("/course/instructor/{name}")
	public List<Course> findCourseByInst(@PathVariable("name") String name) {
		return courseService.findByCourseIntructor(name);
	}
	
	@GetMapping("/course/coursecontaining/{name}")
	public List<Course> findByCourseNameContaining(@PathVariable("name") String name) {
		return courseService.findByCourseNameContaining(name);
	}
	
	@PutMapping("/courses/{cid}")
	public String updateCourse(@PathVariable("cid") Integer courseID, @RequestBody Course updatedCourseData) {
		return courseService.updateCourse(courseID, updatedCourseData);
	}
	
	@DeleteMapping("/courses/{cid}")
	public String deletCourse(@PathVariable("cid") Integer courseID){
		return courseService.deletCourse(courseID);
	}
	
	@PostMapping("/postcourse")
	public String postCourse(@RequestBody Course course) throws Exception{
		try {
			return courseService.postCourse(course);			
		}catch(Exception exception) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,exception.getMessage());
		}
	}
}
