package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.AcademicCourseEntity;
import com.sparrow.entity.CourseLevelEntity;

public interface CourseLevelRepo extends JpaRepository<CourseLevelEntity, Long> {
	@Query(value = "select * from spr_course_level where is_active=1",nativeQuery = true)
	List<CourseLevelEntity> getAllActivelist();
	
	//String getCourselevelById()
	@Query(value = "SELECT course_level_name From spr_course_level WHERE is_active=1 AND course_level_id = :#{#levelId} ", nativeQuery = true)
    String findCourseLevelNameById(@Param("levelId") Long levelId);

}
