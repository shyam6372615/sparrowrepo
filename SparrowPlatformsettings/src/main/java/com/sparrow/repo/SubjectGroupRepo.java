package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.AcademicCourseEntity;
import com.sparrow.entity.SubjectGroupEntity;

public interface SubjectGroupRepo extends JpaRepository<SubjectGroupEntity, Long> {
	@Query(value = "select * from spr_subject_group where is_active=1 And fk_institute_id = :#{#instituteId}  ",nativeQuery = true)
	List<SubjectGroupEntity> getAllActivelist(@Param("instituteId") Long instituteId);

}
