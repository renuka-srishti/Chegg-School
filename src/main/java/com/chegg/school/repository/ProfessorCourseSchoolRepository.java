package com.chegg.school.repository;

import com.chegg.school.model.ProfessorCourseSchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorCourseSchoolRepository extends JpaRepository<ProfessorCourseSchool, Long> {
}