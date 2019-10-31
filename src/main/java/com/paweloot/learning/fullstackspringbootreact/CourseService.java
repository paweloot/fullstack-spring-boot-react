package com.paweloot.learning.fullstackspringbootreact;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>(
            Arrays.asList(
                    new Course("in28minutes", "Learn Full stack with Spring Boot and Angular"),
                    new Course("in28minutes", "Learn Full stack with Spring Boot and React"),
                    new Course("in28minutes", "Master Microservices with Spring Boot and Spring Cloud"),
                    new Course("in28minutes", "Deploy Spring Boot Microservices to Cloud with Docker and Kubernetes")
            )
    );

    public List<Course> findAll() {
        return courses;
    }
}
