package com.chegg.school.controller;

import com.chegg.school.dto.CourseDTO;
import com.chegg.school.model.Course;
import com.chegg.school.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity addCourse(@RequestBody CourseDTO courseDTO) {
        courseService.addCourse(courseDTO.getName());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/deleteCourse")
    public ResponseEntity deleteUser(@RequestBody CourseDTO courseDTO) {
        courseService.deleteCourse(courseDTO);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/updateCourse")
    public ResponseEntity updateUser(@RequestBody CourseDTO courseDTO) {
        courseService.updateCourse(courseDTO);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/listAllCourses")
    public ResponseEntity listCourses() {
        return new ResponseEntity<List<Course>>(courseService.getAllCourses(), HttpStatus.OK);
    }

}
