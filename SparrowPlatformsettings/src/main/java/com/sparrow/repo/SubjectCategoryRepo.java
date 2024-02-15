package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.sparrow.entity.SubjectCategoryEntity;

public interface SubjectCategoryRepo extends JpaRepository<SubjectCategoryEntity, Long> {
	@Query(value = "select * from spr_subject_category where is_active=1 And fk_institute_id = :#{#instituteId}  ",nativeQuery = true)
	List<SubjectCategoryEntity> getAllActivelist(@Param("instituteId") Long instituteId);

}
