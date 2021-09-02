package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

import java.util.List;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			//we can remove the ID because the DB will auto create it for us
			//Hence why we have a constructor in Student.java without the ID
			Student Brian = new Student(
                    "Brian",
                    "Brian@gmail.com",
                    LocalDate.of(1999, 1, 21),
                    21
			);
			
			Student Dylan = new Student(
                    "Dylan",
                    "Dylan@gmail.com",
                    LocalDate.of(1998, 11, 27),
                    23
			);
			
			Student Sean = new Student(
                    "Sean",
                    "Sean@gmail.com",
                    LocalDate.of(1998, 7, 11),
                    23
			);
			
			//Saving to database;
			repository.saveAll(List.of(Brian,Dylan,Sean));
		};
	}
}
