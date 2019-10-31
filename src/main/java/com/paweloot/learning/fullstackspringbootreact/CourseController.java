package com.paweloot.learning.fullstackspringbootreact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;
import java.util.UUID;

// 3000 - React and Vue    4200 - Angular
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/instructors/{username}/courses")
    public List<Course> getAllCourses(@PathVariable String username) {
        return courseService.findAll();
    }

    @GetMapping("/instructors/{username}/courses/{id}")
    public Course getCourse(@PathVariable String username, @PathVariable UUID id) {
        return courseService.findById(id);
    }

    @PostMapping("/instructors/{username}/courses")
    public ResponseEntity<Void> addCourse(@PathVariable String username, @RequestBody Course course) {
        Course createdCourse = courseService.save(course);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdCourse.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/instructors/{username}/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String username, @PathVariable UUID id,
                                               @RequestBody Course course) {

        Course updatedCourse = courseService.save(course);

        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @DeleteMapping("/instructors/{username}/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String username, @PathVariable UUID id) {
        Course course = courseService.deleteById(id);

        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
