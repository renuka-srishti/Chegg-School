package com.chegg.school.exception;

public class CourseNotInSchoolException extends RuntimeException {
    public CourseNotInSchoolException(Long courseId, Long schoolId) {
        super(String.format("Course (%d) not taught in School (%d)", courseId, schoolId));
    }
}
