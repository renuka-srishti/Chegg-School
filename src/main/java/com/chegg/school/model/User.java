package com.chegg.school.model;

import com.chegg.school.enums.UserType;
import com.chegg.school.enums.converter.UserTypeConverter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Getter
@Setter
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_id", discriminatorType = DiscriminatorType.STRING)
@Entity(name = "app_user")
public abstract class User extends AbstractPersistable<Long> {
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_id", nullable = false, insertable = false, updatable = false)
    @Convert(converter = UserTypeConverter.class)
    @Type(type = "postgres_enum")
    private UserType type;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
