package com.chegg.school.service;

import com.chegg.school.model.Professor;
import com.chegg.school.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public void addProfessor(String name, String email) {
        professorRepository.save(new Professor(name, email));
    }

}
