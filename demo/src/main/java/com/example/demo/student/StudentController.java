package com.example.demo.student;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//API LAYER
@RestController
@RequestMapping(path = "api/v1/students") //localhost:8080/api/v1/student
public class StudentController { //all resources for API - API LAYER
	
	//Create reference of StudentService

    private final StudentService studentService;

    //Below is the bad implementation
    /*
    public StudentController(StudentService studentService) {
        this.studentService = new StudentService(); //trying to add an instance of student service
    }*/

    /* BETTER WAY @Autowired*/ 
       //Via dependency injection, it "magically" instantiates studentService and injected into the constructor
       //Now we have have to explicitly say that StudentService has to be instantiated by putting @Service before it
       //Which labels it as a spring bean
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();      
    }
    
    @PostMapping //We have to map the object from the request body INTO the Student student object param via @RequestBody
    public void registerNewStudent(@RequestBody Student student) {
    	studentService.addNewStudents(student);
    }
    
    /*
     * Deleting by ID
     */
    @DeleteMapping(path = "{studentId}")
    public void deleteStudentById(@PathVariable("studentId") Long studentId) {
    	//grab the idea via the @PathVariable and naming it in accordance to its declared variable type in Student.java
    	studentService.deleteStudentById(studentId);
    }
    
    @PutMapping(path = "{SID}")
    public void updateStudent(@PathVariable("SID") Long SID,
    						  @RequestParam(required = false) String name,
    						  @RequestParam (required = false) String email) {
    	studentService.updateStudent(SID, name, email);
    }
    
		
}

