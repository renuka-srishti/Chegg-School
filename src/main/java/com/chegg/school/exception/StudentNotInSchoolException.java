package com.chegg.school.exception;

public class StudentNotInSchoolException extends RuntimeException {
    public StudentNotInSchoolException(Long studentId, Long schoolId) {
        super(String.format("Student (%d) not in School (%d)", studentId, schoolId));
    }
}
