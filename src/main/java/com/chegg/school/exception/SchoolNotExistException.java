package com.chegg.school.exception;

public class SchoolNotExistException extends RuntimeException {
    public SchoolNotExistException(Long schoolId) {
        super(String.format("School does not exist with id: %d", schoolId));
    }
}
