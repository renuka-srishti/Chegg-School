package com.chegg.school.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class UserDTO {
    @Nullable
    Boolean isProfessor;

    @Nullable
    String name;

    @Nullable
    String email;

    @Nullable
    Long id;
}
