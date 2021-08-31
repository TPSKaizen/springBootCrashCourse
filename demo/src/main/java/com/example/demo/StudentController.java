package com.example.demo;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//API LAYER
@RestController
@RequestMapping(path = "api/v1/student") //localhost:8080/api/v1/student
public class StudentController { //all resources for API
	
	//Create reference of StudentService
		
		private final StudentService studentService;
		
		public StudentController(StudentService studentService) {
			this.studentService = studentService;
		}
		
		@GetMapping
		public List<Student> getStudents(){
			return studentService.getStudents();
		}
		
}
