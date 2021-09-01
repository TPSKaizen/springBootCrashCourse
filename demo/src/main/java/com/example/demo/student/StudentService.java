package com.example.demo.student;

import java.time.LocalDate;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class StudentService {
        //BUSINESS LOGIC
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

    } // this returns an array of objects/

}