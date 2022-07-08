package com.rivaldo.crescendodigital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	//@RequestMapping(value = "/",method = RequestMethod.GET)
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/about")
	public String about() {
		return "I am about page";
	}
}
