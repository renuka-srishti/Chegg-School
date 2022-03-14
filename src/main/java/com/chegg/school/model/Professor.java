package com.chegg.school.model;

import com.chegg.school.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@DiscriminatorValue(value = UserType.Constants.PROFESSOR)
public class Professor extends User {

    @ManyToMany(mappedBy = "professors")
    Set<School> schools = new HashSet<>();

    public Professor() {
    }

    public Professor(String name, String email) {
        super(name, email);
    }
}
