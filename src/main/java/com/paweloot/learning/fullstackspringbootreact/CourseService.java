package com.paweloot.learning.fullstackspringbootreact;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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

    public Course findById(UUID id) {
        return courses.stream().filter(course -> course.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Course save(Course course) {
        if (course.getId().toString().equals("-1")) {
            course.setId(UUID.randomUUID());
            courses.add(course);
        } else {
            deleteById(course.getId());
            courses.add(course);
        }

        return course;
    }

    public Course deleteById(UUID id) {
        Course course = findById(id);

        if (course != null)
            courses.remove(course);

        return course;
    }
}
