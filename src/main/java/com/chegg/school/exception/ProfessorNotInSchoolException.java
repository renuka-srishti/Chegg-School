package com.chegg.school.exception;

public class ProfessorNotInSchoolException extends RuntimeException {
    public ProfessorNotInSchoolException(Long professorId, Long schoolId) {
        super(String.format("Professor (%d) does not teaches in School (%d)", professorId, schoolId));
    }
}
