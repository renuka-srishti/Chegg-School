package com.chegg.school.controller;


import com.chegg.school.dto.SchoolDTO;
import com.chegg.school.model.Course;
import com.chegg.school.model.Professor;
import com.chegg.school.model.School;
import com.chegg.school.model.Student;
import com.chegg.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping("/addSchool")
    public ResponseEntity addSchool(@RequestBody SchoolDTO schoolDTO) {
        schoolService.addSchool(schoolDTO.getName());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/addCoursesToSchool")
    public ResponseEntity addCoursesToSchool(@RequestBody SchoolDTO schoolDTO) {
        schoolService.addCoursesToSchool(schoolDTO.getId(), schoolDTO.getCourseIds());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/addStudentsToSchool")
    public ResponseEntity addStudentsToSchool(@RequestBody SchoolDTO schoolDTO) {
        schoolService.addStudentsToSchool(schoolDTO.getId(), schoolDTO.getStudentIds());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/addProfessorsToSchool")
    public ResponseEntity addProfessorsToSchool(@RequestBody SchoolDTO schoolDTO) {
        schoolService.addProfessorsToSchool(schoolDTO.getId(), schoolDTO.getProfessorIds());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/assignCourseToProfessorInSchool")
    public ResponseEntity assignCourseToProfessor(@RequestParam long schoolId, @RequestParam long courseId, @RequestParam long professorId) {
        schoolService.assignCourseToProfessorInSchool(schoolId, courseId, professorId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/assignCourseToStudentInSchool")
    public ResponseEntity assignCourseToStudent(@RequestParam long courseId, @RequestParam long studentId) {
        schoolService.assignCourseToStudentInSchool(courseId, studentId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/removeStudentFromSchool")
    public ResponseEntity removeStudentFromSchool(@RequestParam long schoolId, @RequestParam long studentId) {
        schoolService.removeStudentFromSchool(schoolId, studentId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/deleteSchool")
    public ResponseEntity deleteSchool(@RequestParam long schoolId) {
        schoolService.deleteSchool(schoolId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/listAllCoursesInSchool/{schoolId}")
    public List<Course> listAllCoursesInSchool(@PathVariable Long schoolId) {
        return schoolService.listAllCoursesInSchool(schoolId);
    }

    @GetMapping("/listAllStudentsInSchool/{schoolId}")
    public List<Student> listAllStudentsInSchool(@PathVariable Long schoolId) {
        return schoolService.listAllStudentsInSchool(schoolId);
    }

    @GetMapping("/listAllProfessorsInSchool/{schoolId}")
    public List<Professor> listAllProfessorsInSchool(@PathVariable Long schoolId) {
        return schoolService.listAllProfessorsInSchool(schoolId);
    }

    @GetMapping("/listAllSchools")
    public List<School> listAllSchools() {
        return  schoolService.getAllSchools();
    }
}
