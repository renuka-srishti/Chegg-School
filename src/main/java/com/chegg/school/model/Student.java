package com.chegg.school.model;

import com.chegg.school.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@DiscriminatorValue(value = UserType.Constants.STUDENT)
public class Student extends User {

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    @ManyToOne
    @JoinTable(name = "school_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "school_id"))
    private School school;

    public Student() {
    }

    public Student(String name, String email) {
        super(name, email);
    }

    public void removeAllCourses() {
        courses = new HashSet<>();
    }
}
