package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.AcademicCourseEntity;


public interface AcademicCourseRepo extends JpaRepository<AcademicCourseEntity, Long> {
	@Query(value = "select * from spr_academic_courses where is_active=1 And fk_institute_id = :#{#instituteId}  ",nativeQuery = true)
	List<AcademicCourseEntity> getAllActivelist(@Param("instituteId") Long instituteId);
	@Query(value = "select * from spr_academic_courses where is_active=1 And fk_institute_id = :#{#instituteId} And academic_course_id= :#{#academicCourseId} ",nativeQuery = true)
	AcademicCourseEntity getAcademicCourseById(@Param("instituteId") Long instituteId,@Param("academicCourseId") Long academicCourseId);
}
