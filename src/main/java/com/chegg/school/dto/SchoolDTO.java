package com.chegg.school.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter
@Setter
public class SchoolDTO {
    @Nullable
    String name;

    @Nullable
    Long id;

    @Nullable
    List<Long> studentIds;

    @Nullable
    List<Long> courseIds;

    @Nullable
    List<Long> professorIds;
}
