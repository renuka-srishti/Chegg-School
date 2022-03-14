package com.chegg.school.service;

import com.chegg.school.exception.CourseNotExistException;
import com.chegg.school.exception.CourseNotInSchoolException;
import com.chegg.school.exception.ProfessorNotExistException;
import com.chegg.school.exception.ProfessorNotInSchoolException;
import com.chegg.school.exception.SchoolNotExistException;
import com.chegg.school.exception.StudentNotExistException;
import com.chegg.school.exception.StudentNotInSchoolException;
import com.chegg.school.model.Course;
import com.chegg.school.model.Professor;
import com.chegg.school.model.ProfessorCourseSchool;
import com.chegg.school.model.School;
import com.chegg.school.model.Student;
import com.chegg.school.repository.CourseRepository;
import com.chegg.school.repository.ProfessorCourseSchoolRepository;
import com.chegg.school.repository.ProfessorRepository;
import com.chegg.school.repository.SchoolRepository;
import com.chegg.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ProfessorRepository professorRepository;
    private final ProfessorCourseSchoolRepository professorCourseSchoolRepository;

    public void addSchool(String name) {
        schoolRepository.save(new School(name));
    }

    public void deleteSchool(Long schoolId) {
        if (!schoolRepository.existsById(schoolId)) {
            throw new SchoolNotExistException(schoolId);
        }

        School school = schoolRepository.getById(schoolId);

        schoolRepository.delete(school);
    }

    public void addStudentsToSchool(Long schoolId, List<Long> studentIds) {
        if (!schoolRepository.existsById(schoolId)) {
            throw new SchoolNotExistException(schoolId);
        }

        School school = schoolRepository.getById(schoolId);

        for (Long id : studentIds) {
            if (studentRepository.existsById(id)) {
                Student student = studentRepository.getById(id);
                school.addStudent(student);
                studentRepository.save(student);
            }
        }
        schoolRepository.save(school);
    }

    public void addCoursesToSchool(Long schoolId, List<Long> courseIds) {
        if (!schoolRepository.existsById(schoolId)) {
            throw new SchoolNotExistException(schoolId);
        }

        School school = schoolRepository.getById(schoolId);

        for (Long id : courseIds) {
            if (courseRepository.existsById(id)) {
                Course course = courseRepository.getById(id);
                school.addCourse(course);
                courseRepository.save(course);
            }
        }
        schoolRepository.save(school);
    }

    public void addProfessorsToSchool(Long schoolId, List<Long> professorIds) {
        if (!schoolRepository.existsById(schoolId)) {
            throw new SchoolNotExistException(schoolId);
        }

        School school = schoolRepository.getById(schoolId);

        for (Long id : professorIds) {
            if (professorRepository.existsById(id)) {
                Professor professor = professorRepository.getById(id);
                school.addProfessor(professor);
                professorRepository.save(professor);
            }
        }
        schoolRepository.save(school);
    }

    public void assignCourseToProfessorInSchool(Long schoolId, Long courseId, Long professorId) {
        if (!schoolRepository.existsById(schoolId)) {
            throw new SchoolNotExistException(schoolId);
        }

        if (!courseRepository.existsById(courseId)) {
            throw new CourseNotExistException(courseId);
        }

        if (!professorRepository.existsById(professorId)) {
            throw new ProfessorNotExistException(professorId);
        }

        School school = schoolRepository.getById(schoolId);
        Course course = courseRepository.getById(courseId);
        Professor professor = professorRepository.getById(professorId);

        if (!school.getCourses().contains(course)) {
            throw new CourseNotInSchoolException(courseId, schoolId);
        }

        if (!school.getProfessors().contains(professor)) {
            throw new ProfessorNotInSchoolException(professorId, schoolId);
        }

        professorCourseSchoolRepository.save(new ProfessorCourseSchool(school, course, professor));
    }

    public void assignCourseToStudentInSchool(Long courseId, Long studentId) {
        if (!courseRepository.existsById(courseId)) {
            throw new CourseNotExistException(courseId);
        }

        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotExistException(studentId);
        }

        Student student = studentRepository.getById(studentId);
        Course course = courseRepository.getById(courseId);
        School school = student.getSchool();

        if (!school.getCourses().contains(course)) {
            throw new CourseNotInSchoolException(courseId, school.getId());
        }

        student.addNewCourse(course);
        courseRepository.save(course);
        studentRepository.save(student);
    }

    public void removeStudentFromSchool(Long schoolId, Long studentId) {
        if (!schoolRepository.existsById(schoolId)) {
            throw new SchoolNotExistException(schoolId);
        }

        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotExistException(studentId);
        }

        School school = schoolRepository.getById(schoolId);
        Student student = studentRepository.getById(schoolId);

        if (!school.getStudents().contains(student)) {
            throw new StudentNotInSchoolException(studentId, schoolId);
        }

        school.removeStudent(student);
        studentRepository.save(student);
        schoolRepository.save(school);
    }

    public List<Course> listAllCoursesInSchool(Long schoolId) {
        if (!schoolRepository.existsById(schoolId)) {
            throw new SchoolNotExistException(schoolId);
        }

        School school = schoolRepository.getById(schoolId);
        return List.copyOf(school.getCourses());
    }

    public List<Student> listAllStudentsInSchool(Long schoolId) {
        if (!schoolRepository.existsById(schoolId)) {
            throw new SchoolNotExistException(schoolId);
        }

        School school = schoolRepository.getById(schoolId);
        return List.copyOf(school.getStudents());
    }

    public List<Professor> listAllProfessorsInSchool(Long schoolId) {
        if (!schoolRepository.existsById(schoolId)) {
            throw new SchoolNotExistException(schoolId);
        }

        School school = schoolRepository.getById(schoolId);
        return List.copyOf(school.getProfessors());
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }
}
