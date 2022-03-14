package com.chegg.school.service;

import com.chegg.school.model.Course;
import com.chegg.school.model.Professor;
import com.chegg.school.model.School;
import com.chegg.school.model.Student;
import com.chegg.school.repository.CourseRepository;
import com.chegg.school.repository.ProfessorCourseSchoolRepository;
import com.chegg.school.repository.ProfessorRepository;
import com.chegg.school.repository.SchoolRepository;
import com.chegg.school.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SchoolServiceTest {

    @Mock
    private SchoolRepository schoolRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private ProfessorRepository professorRepository;

    @Mock
    private ProfessorCourseSchoolRepository professorCourseSchoolRepository;

    @InjectMocks
    private SchoolService schoolService;

    private School testSchool;
    private Professor testProfessor;
    private Course testCourse;
    private Student testStudent;

    @BeforeEach
    void setUp() {
        testSchool = new School("Test School");
        testCourse = new Course("Test Course");
        testStudent = new Student("Test Student", "testStudent@email.com");
        testProfessor = new Professor("Test Professor", "testProfessor@email.com");
    }

    @Test
    void addSchool() {
        when(schoolRepository.save(any(School.class))).thenReturn(testSchool);

        schoolService.addSchool(testSchool.getName());

        verify(schoolRepository, times(1)).save(any());
    }

    @Test
    void deleteSchool() {
        when(schoolRepository.existsById(1L)).thenReturn(true);
        when(schoolRepository.getById(1L)).thenReturn(testSchool);

        schoolService.deleteSchool(1L);

        verify(schoolRepository, times(1)).delete(any());
    }

    @Test
    void addStudentsToSchool() {
        when(schoolRepository.existsById(1L)).thenReturn(true);
        when(schoolRepository.getById(1L)).thenReturn(testSchool);
        when(studentRepository.existsById(1L)).thenReturn(true);
        when(studentRepository.getById(1L)).thenReturn(testStudent);

        schoolService.addStudentsToSchool(1L, Collections.singletonList(1L));

        verify(studentRepository, times(1)).save(any());
        verify(schoolRepository, times(1)).save(any());
    }

    @Test
    void addCoursesToSchool() {
        when(schoolRepository.existsById(1L)).thenReturn(true);
        when(schoolRepository.getById(1L)).thenReturn(testSchool);
        when(courseRepository.existsById(1L)).thenReturn(true);
        when(courseRepository.getById(1L)).thenReturn(testCourse);

        schoolService.addCoursesToSchool(1L, Collections.singletonList(1L));

        verify(courseRepository, times(1)).save(any());
        verify(schoolRepository, times(1)).save(any());
    }

    @Test
    void addProfessorsToSchool() {
        when(schoolRepository.existsById(1L)).thenReturn(true);
        when(schoolRepository.getById(1L)).thenReturn(testSchool);
        when(professorRepository.existsById(1L)).thenReturn(true);
        when(professorRepository.getById(1L)).thenReturn(testProfessor);

        schoolService.addProfessorsToSchool(1L, Collections.singletonList(1L));

        verify(professorRepository, times(1)).save(any());
        verify(schoolRepository, times(1)).save(any());
    }

    @Test
    void assignCourseToProfessorInSchool() {
        testSchool.addCourse(testCourse);
        testSchool.addProfessor(testProfessor);

        when(schoolRepository.existsById(1L)).thenReturn(true);
        when(schoolRepository.getById(1L)).thenReturn(testSchool);

        when(courseRepository.existsById(1L)).thenReturn(true);
        when(courseRepository.getById(1L)).thenReturn(testCourse);

        when(professorRepository.existsById(1L)).thenReturn(true);
        when(professorRepository.getById(1L)).thenReturn(testProfessor);

        schoolService.assignCourseToProfessorInSchool(1L, 1L, 1l);

        verify(professorCourseSchoolRepository, times(1)).save(any());
    }

    @Test
    void removeStudentFromSchool() {
        testSchool.addStudent(testStudent);

        when(schoolRepository.existsById(1L)).thenReturn(true);
        when(schoolRepository.getById(1L)).thenReturn(testSchool);

        when(studentRepository.existsById(1L)).thenReturn(true);
        when(studentRepository.getById(1L)).thenReturn(testStudent);

        schoolService.removeStudentFromSchool(1L, 1L);

        verify(studentRepository, times(1)).save(any());
        verify(schoolRepository, times(1)).save(any());
    }

    @Test
    void listAllCoursesInSchool() {
        testSchool.addCourse(testCourse);

        when(schoolRepository.existsById(1L)).thenReturn(true);
        when(schoolRepository.getById(1L)).thenReturn(testSchool);

        List<Course> returnedCourses = schoolService.listAllCoursesInSchool(1L);

        assertEquals(Collections.singletonList(testCourse), returnedCourses);
    }

    @Test
    void listAllStudentsInSchool() {
        testSchool.addStudent(testStudent);

        when(schoolRepository.existsById(1L)).thenReturn(true);
        when(schoolRepository.getById(1L)).thenReturn(testSchool);

        List<Student> returnedStudents = schoolService.listAllStudentsInSchool(1L);

        assertEquals(Collections.singletonList(testStudent), returnedStudents);
    }

    @Test
    void listAllProfessorsInSchool() {
        testSchool.addProfessor(testProfessor);

        when(schoolRepository.existsById(1L)).thenReturn(true);
        when(schoolRepository.getById(1L)).thenReturn(testSchool);

        List<Professor> returnedProfessors = schoolService.listAllProfessorsInSchool(1L);

        assertEquals(Collections.singletonList(testProfessor), returnedProfessors);
    }

    @Test
    void getAllSchools() {
        when(schoolRepository.findAll()).thenReturn(Collections.singletonList(testSchool));

        List<School> returnedSchools = schoolService.getAllSchools();

        assertEquals(Collections.singletonList(testSchool), returnedSchools);
    }
}