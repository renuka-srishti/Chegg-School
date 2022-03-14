package com.chegg.school.exception;

public class StudentNotExistException extends RuntimeException {
    public StudentNotExistException(Long studentId) {
        super(String.format("Student does not exist with id: %d", studentId));
    }
}
