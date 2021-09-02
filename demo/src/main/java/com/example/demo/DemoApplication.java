package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.student.Student;

@SpringBootApplication

// public class DemoApplication implements CommandLineRunner{
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		/*
		 * in pom.xml, comment out the spring-boot-starter-data-jpa dependency
		 * until you are ready to connect to a DB
		 */
	}
	
	/*
	@Autowired
    private JdbcTemplate jdbcTemplate;

	
	@Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM students";
        List<Student> students = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Student.class));
         
        students.forEach(System.out :: println);
    }*/
		
}