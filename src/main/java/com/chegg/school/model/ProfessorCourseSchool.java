package com.chegg.school.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class ProfessorCourseSchool extends AbstractPersistable<Long> {

    @OneToOne
    @JoinColumn(name = "school_id")
    School school;

    @OneToOne
    @JoinColumn(name = "course_id")
    Course course;

    @OneToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public ProfessorCourseSchool() {
    }

    public ProfessorCourseSchool(School school, Course course, Professor professor) {
        this.school = school;
        this.course = course;
        this.professor = professor;
    }
}
