package com.chegg.school.service;

import com.chegg.school.dto.UserDTO;
import com.chegg.school.enums.UserType;
import com.chegg.school.exception.ProfessorNotExistException;
import com.chegg.school.exception.StudentNotExistException;
import com.chegg.school.model.Professor;
import com.chegg.school.model.Student;
import com.chegg.school.model.User;
import com.chegg.school.repository.ProfessorRepository;
import com.chegg.school.repository.StudentRepository;
import com.chegg.school.exception.UserNotExistException;
import com.chegg.school.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserService {
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final UserRepository userRepository;

    public void adduser(String name, String email, Boolean isProfessor) {
        if (isProfessor) {
            addProfessor(name, email);
        } else {
            addStudent(name, email);
        }
    }

    public void deleteUser(UserDTO userDTO) {
        Long userId = userDTO.getId();
        if (!userRepository.existsById(userId)){
            throw new UserNotExistException(userId);
        }
        User user = userRepository.getById(userId);

        if (user.getType().equals(UserType.PROFESSOR)) {
            deleteProfessor(userId);
        } else {
            deleteStudent(userId);
        }
    }

    public void updateUser(UserDTO userDTO) {
        if ( userDTO.getId() != null && !userRepository.existsById(userDTO.getId())){
            throw new UserNotExistException(userDTO.getId());
        }

        User user = userRepository.getById(userDTO.getId());
        if (user.getType().equals(UserType.PROFESSOR)) {
            updateProfessor(user, userDTO);
        } else {
            updateStudent(user, userDTO);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addStudent(String name, String email) {
        studentRepository.save(new Student(name, email));
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotExistException(studentId);
        }
        Student student = studentRepository.getById(studentId);
        studentRepository.delete(student);
    }

    public void updateStudent(User user, UserDTO userDTO) {
        if (!studentRepository.existsById(user.getId())) {
            throw new StudentNotExistException(user.getId());
        }

        Student oldStudent = studentRepository.getById(user.getId());

        oldStudent.setName(userDTO.getName());
        oldStudent.setEmail(userDTO.getEmail());

        studentRepository.save(oldStudent);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addProfessor(String name, String email) {
        professorRepository.save(new Professor(name, email));
    }

    public void deleteProfessor(Long professorId) {
        if (!professorRepository.existsById(professorId)) {
            throw new ProfessorNotExistException(professorId);
        }
        Professor professor = professorRepository.getById(professorId);
        professorRepository.delete(professor);
    }

    public void updateProfessor(User user, UserDTO userDTO) {
        if (!professorRepository.existsById(user.getId())) {
            throw new ProfessorNotExistException(user.getId());
        }

        Professor oldProfessor = professorRepository.getById(user.getId());

        oldProfessor.setName(userDTO.getName());
        oldProfessor.setEmail(userDTO.getEmail());

        professorRepository.save(oldProfessor);
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

}
