package com.chegg.school.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Course extends AbstractPersistable<Long> {

    String name;

    @ManyToMany(mappedBy = "courses")
    Set<School> schools = new HashSet<>();

    @ManyToMany(mappedBy = "courses")
    Set<Student> students = new HashSet<>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }
}
