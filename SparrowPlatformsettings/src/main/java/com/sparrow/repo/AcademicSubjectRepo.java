package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.AcademicCourseEntity;
import com.sparrow.entity.AcademicSubjectEntity;
import com.sparrow.entity.DepartmentEntity;

public interface AcademicSubjectRepo extends JpaRepository<AcademicSubjectEntity, Long> {
	@Query(value = "select * from spr_academic_subjects where is_active=1 And fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<AcademicSubjectEntity> getAllActivelist(@Param("instituteId") Long instituteId);
	@Query(value = "select * from spr_academic_subjects where is_active=1 And fk_institute_id = :#{#instituteId} And academic_subject_id= :#{#academicSubId} ",nativeQuery = true)
	AcademicSubjectEntity getAcademicSubById(@Param("instituteId") Long instituteId,@Param("academicSubId") Long academicSubId);

}
