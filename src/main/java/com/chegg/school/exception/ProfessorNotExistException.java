package com.chegg.school.exception;

public class ProfessorNotExistException extends RuntimeException {
    public ProfessorNotExistException(Long professorId) {
        super(String.format("Professor does not exist with id: %d", professorId));
    }
}
