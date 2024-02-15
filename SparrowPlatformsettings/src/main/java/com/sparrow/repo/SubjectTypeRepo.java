package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.sparrow.entity.SubjectTypeEntity;

public interface SubjectTypeRepo extends JpaRepository<SubjectTypeEntity, Long> {
	@Query(value = "select * from spr_subject_type where is_active=1",nativeQuery = true)
	List<SubjectTypeEntity> getAllActivelist();

}
