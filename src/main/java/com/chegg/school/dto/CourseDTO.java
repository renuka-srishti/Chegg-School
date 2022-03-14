package com.chegg.school.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class CourseDTO {
    @Nullable
    String name;

    @Nullable
    Long id;
}
