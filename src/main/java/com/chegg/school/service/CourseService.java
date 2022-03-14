package com.chegg.school.service;

import com.chegg.school.exception.CourseNotExistException;
import com.chegg.school.model.Course;
import com.chegg.school.repository.CourseRepository;
import com.chegg.school.dto.CourseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public void addCourse(String name) {
        courseRepository.save(new Course(name));
    }

    public void deleteCourse(CourseDTO courseDTO) {
        Long courseId = courseDTO.getId();
        if (!courseRepository.existsById(courseId)) {
            throw new CourseNotExistException(courseId);
        }

        courseRepository.delete(courseRepository.getById(courseId));
    }

    public void updateCourse(CourseDTO courseDTO) {
        Long courseId = courseDTO.getId();
        if (!courseRepository.existsById(courseId)) {
            throw new CourseNotExistException(courseId);
        }

        Course course = courseRepository.getById(courseId);
        course.setName(courseDTO.getName());
        courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

}
