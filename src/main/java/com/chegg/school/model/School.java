package com.chegg.school.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class School extends AbstractPersistable<Long> {

    String name;

    @ManyToMany
    @JoinTable(
            name = "school_course",
            joinColumns = @JoinColumn(name = "school_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Course> courses = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "school_professor",
            joinColumns = @JoinColumn(name = "school_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    Set<Professor> professors = new HashSet<>();

    @OneToMany(mappedBy = "school")
    Set<Student> students = new HashSet<>();

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setSchool(this);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.getSchools().add(this);
    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
        professor.getSchools().add(this);
    }

    public void removeStudent(Student student) {
        this.getStudents().remove(student);
        student.removeAllCourses();
        student.setSchool(null);
    }

    public void removeCourse(Course course) {
        this.getCourses().remove(course);
        course.getSchools().remove(this);
    }

    public void removeProfessor(Professor professor) {
        this.getProfessors().remove(professor);
        professor.getSchools().remove(this);
    }
}
