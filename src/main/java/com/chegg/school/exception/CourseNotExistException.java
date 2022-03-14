package com.chegg.school.exception;

public class CourseNotExistException extends RuntimeException {
    public CourseNotExistException(Long courseId) {
        super(String.format("Course does not exist with id: %d", courseId));
    }
}
