package com.chegg.school.service;

import com.chegg.school.model.Student;
import com.chegg.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(String name, String email) {
        studentRepository.save(new Student(name, email));
    }

}
