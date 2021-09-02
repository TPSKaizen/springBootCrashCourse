package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Reponsible for data access. Data Access Layer

//We have to connect the Data Access Layer to the Student Service Layer via Dependency Injection
public interface StudentRepository extends JpaRepository<Student, Long> {

	//Repo will work with type student and ID param is of type Long
	
	//Connect
}
