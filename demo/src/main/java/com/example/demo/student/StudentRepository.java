package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository //Reponsible for data access. Data Access Layer

//We have to connect the Data Access Layer to the Student Service Layer via Dependency Injection
public interface StudentRepository extends JpaRepository<Student, Long> {

	//Repo will work with type student and ID param is of type Long
	
	// SELECT * FROM student where EMAIL = param
	@Query("SELECT s from Student s WHERE s.email = ?1")
	// First s is an alias
	// Student s refers to an instance of Student class
	//For custom functions we use Optional
	Optional<Student> findStudentByEmail(String email);
}
