package com.example.demo.student;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

//@Component and @Service are the same, but different for Semantics
@Service 
public class StudentService {
        //BUSINESS LOGIC - SERVICE LAYER
		//We have to connect this layer to the API layer via Dependency Injection
	
	private final StudentRepository studentRepo;
	
	@Autowired
	public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }
	
    @GetMapping 
    public List<Student> getStudents() {
        return studentRepo.findAll(); //returns a List
       
    } // this returns an array of objects generated in the code and not from the database

	public void addNewStudents(Student student) {
		// TODO Auto-generated method stub
		//System.out.println(student); for testing 
		//Check if student is present via custom function declared in StudentRepo
		Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());
		if(studentOptional.isPresent()) 
			throw new IllegalStateException("Email taken");
		else 
			studentRepo.save(student);
	}

	
	public void deleteStudentById(Long studentId) {
		// TODO Auto-generated method stub
		boolean foundId = studentRepo.existsById(studentId);
		//if it exists
		if(!foundId) 
			throw new IllegalStateException("Student with id: " + studentId + " was not found");	
		else
			studentRepo.deleteById(studentId);
	}

}

//GET METHOD without using database

/*
@GetMapping 
public List<Student> getStudents() {
    return List.of(
            new Student(
                    1L,
                    "Brian",
                    "Brian@gmail.com",
                    LocalDate.of(1999, 1, 21),
                    21
            ), 

            new Student(
                    2L,
                    "Briana",
                    "Briana@gmail.com",
                    LocalDate.of(1999, 1, 25),
                    21
            ),

            new Student(
                    3L,
                    "Brianna",
                    "Brianba@gmail.com",
                    LocalDate.of(1999, 1, 23),
                    21
            )
    );

} // */


//to have this method to be served as a RESTFUL Endpoint
/*@GetMapping 
public String hello() {
    return "<h1> Hello World </h1>";
}*/

/*
@GetMapping 
public List<String> hello() {
    return List.of("Array", "Boobby");

} // Returns Json array
*/